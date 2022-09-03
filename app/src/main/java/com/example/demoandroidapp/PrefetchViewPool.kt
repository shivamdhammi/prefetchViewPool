package com.example.demoandroidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import java.util.*

class PrefetchViewPool {

    /**
     *  Below mentioned 3 lists handles the prefetching flow.
     *
     *  [prefetchViewTypeList] contains layoutIds in it's key and prefetch count in it's value.
     *
     *  [prefetchChildViewTypeList] contains parent layoutId in key & child layoutID and prefetch count in it's value as a Pair.
     *
     *  [prefetchItemBindingMap] contains layoutIds in it's key and ViewBindings in it's value.
     */

    private var prefetchViewTypeList = HashMap<Int, Int>()
    private var prefetchChildViewTypeList = HashMap<Int, Pair<Int, Int>>()
    private var prefetchItemBindingMap = HashMap<Int, Queue<ViewDataBinding>>()
    private var isAdapterDetached: Boolean = false

    /**
     * Parent adapter must provide a non-empty HashMap to enable prefetching.
     * This method sets the value to [prefetchViewTypeList]
     * key - layoutId
     * value - prefetchCount
     */
    fun setPrefetchedViewTypeList(viewTypeList: HashMap<Int, Int>) {
        prefetchViewTypeList.clear()
        prefetchViewTypeList.putAll(viewTypeList)
    }

    /**
     * Parent adapter must provide a non-empty HashMap to enable child prefetching.
     * This method sets the value to [prefetchViewTypeList]
     * key - parent's layoutId
     * value - child's layoutId and its prefetchCount
     */
    fun setPrefetchedChildViewTypeList(viewTypeList: HashMap<Int, Pair<Int, Int>>) {
        prefetchChildViewTypeList.clear()
        prefetchChildViewTypeList.putAll(viewTypeList)
    }

    /**
     * This method prefetches the viewBinding based on the layoutId mentioned the [prefetchViewTypeList].
     * and stores them into [prefetchItemBindingMap]
     */
    fun prefetchItemBinding(parent: ViewGroup) {
        if (prefetchViewTypeList.isEmpty()) return

        prefetchViewTypeList.forEach { viewTypeToCount ->
            if (isAdapterDetached) return
            if (prefetchItemBindingMap[viewTypeToCount.key] != null) return@forEach

            initAsyncItemBinding(parent, viewTypeToCount.key, viewTypeToCount.value)
        }
    }

    /**
     * This method prefetches the child viewBinding based on the layoutId mentioned the [prefetchChildViewTypeList].
     * and stores them into [prefetchItemBindingMap]
     */
    private fun prefetchChildItemBinding(parentViewBinding: ViewDataBinding, parentLayoutId: Int) {
        if (isAdapterDetached) return
        if (prefetchItemBindingMap[parentLayoutId] == null) return
        if (prefetchChildViewTypeList.isEmpty()) return
        val viewTypeToCount = prefetchChildViewTypeList[parentLayoutId] ?: return
        if (prefetchItemBindingMap[viewTypeToCount.first] != null) return

        initAsyncItemBinding(
            parentViewBinding.root as ViewGroup,
            viewTypeToCount.first,
            viewTypeToCount.second
        )
    }

    /**
     * Gives the perfected viewBinding based on the mentioned layoutId in the argument.
     * if the [prefetchItemBindingMap] is null or empty than
     * a new viewBinding will be initialized and returned.
     */
    fun getPrefetchedItemBinding(parent: ViewGroup, layoutId: Int): ViewDataBinding {
        return prefetchItemBindingMap[layoutId]?.poll() ?: initItemBinding(parent, layoutId)
    }

    /**
     * Call this method from adapter's onDetachedFromRecyclerView to stop making more ViewDataBinding.
     */
    fun detachedFromRecyclerView() {
        isAdapterDetached = true
    }

    private fun initItemBinding(parent: ViewGroup, layoutId: Int): ViewDataBinding {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return DataBindingUtil.inflate(
            layoutInflater,
            layoutId,
            parent,
            false
        )
    }

    private fun initAsyncItemBinding(parent: ViewGroup, layoutId: Int, count: Int) {

        val layoutInflater = AsyncLayoutInflater(parent.context)

        for (index in 0 until count) {
            if (isAdapterDetached) return
            layoutInflater.inflate(layoutId, parent) { view, _, _ ->
                run {

                    val viewBindingList: Queue<ViewDataBinding> =
                        prefetchItemBindingMap[layoutId] ?: ArrayDeque()
                    val itemViewBinding = DataBindingUtil.bind<ViewDataBinding>(view)

                    viewBindingList.add(itemViewBinding)
                    prefetchItemBindingMap[layoutId] = viewBindingList

                    if (index == 0) {
                        prefetchChildItemBinding(itemViewBinding!!, layoutId)
                    }
                }
            }
        }

    }
}
