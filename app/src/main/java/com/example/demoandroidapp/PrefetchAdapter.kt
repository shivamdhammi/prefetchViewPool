package com.example.demoandroidapp

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class PrefetchAdapter: RecyclerView.Adapter<PrefetchViewHolder>() {

    private val prefetchViewPool = PrefetchViewPool()
    private var list: List<String> = emptyList()

    init {
        val prefetchItemMap = hashMapOf(
            R.layout.item_recycler_view to 4
        )
        prefetchViewPool.setPrefetchedViewTypeList(prefetchItemMap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrefetchViewHolder {
        val binding = prefetchViewPool.getPrefetchedItemBinding(parent,R.layout.item_recycler_view)
        return PrefetchViewHolder(binding,BR.item)
    }

    override fun onBindViewHolder(holder: PrefetchViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        prefetchViewPool.detachedFromRecyclerView()
    }

    fun setData(list: List<String>){
        this.list = list
        notifyDataSetChanged()
    }

}

class PrefetchViewHolder(val binding: ViewDataBinding,private val bindingVariableId: Int): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: String?) {
        binding.setVariable(bindingVariableId, item)
        binding.executePendingBindings()
    }
}