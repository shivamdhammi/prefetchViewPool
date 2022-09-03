package com.example.demoandroidapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001a\u001a\u00020\u000e2\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\b0\u0006J\u001a\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/demoandroidapp/PrefetchViewPool;", "", "()V", "isAdapterDetached", "", "prefetchChildViewTypeList", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "prefetchItemBindingMap", "Ljava/util/Queue;", "Landroidx/databinding/ViewDataBinding;", "prefetchViewTypeList", "detachedFromRecyclerView", "", "getPrefetchedItemBinding", "parent", "Landroid/view/ViewGroup;", "layoutId", "initAsyncItemBinding", "count", "initItemBinding", "prefetchChildItemBinding", "parentViewBinding", "parentLayoutId", "prefetchItemBinding", "setPrefetchedChildViewTypeList", "viewTypeList", "setPrefetchedViewTypeList", "app_debug"})
public final class PrefetchViewPool {
    
    /**
     * Below mentioned 3 lists handles the prefetching flow.
     *
     * [prefetchViewTypeList] contains layoutIds in it's key and prefetch count in it's value.
     *
     * [prefetchChildViewTypeList] contains parent layoutId in key & child layoutID and prefetch count in it's value as a Pair.
     *
     * [prefetchItemBindingMap] contains layoutIds in it's key and ViewBindings in it's value.
     */
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> prefetchViewTypeList;
    private java.util.HashMap<java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> prefetchChildViewTypeList;
    private java.util.HashMap<java.lang.Integer, java.util.Queue<androidx.databinding.ViewDataBinding>> prefetchItemBindingMap;
    private boolean isAdapterDetached = false;
    
    public PrefetchViewPool() {
        super();
    }
    
    /**
     * Parent adapter must provide a non-empty HashMap to enable prefetching.
     * This method sets the value to [prefetchViewTypeList]
     * key - layoutId
     * value - prefetchCount
     */
    public final void setPrefetchedViewTypeList(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.Integer, java.lang.Integer> viewTypeList) {
    }
    
    /**
     * Parent adapter must provide a non-empty HashMap to enable child prefetching.
     * This method sets the value to [prefetchViewTypeList]
     * key - parent's layoutId
     * value - child's layoutId and its prefetchCount
     */
    public final void setPrefetchedChildViewTypeList(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> viewTypeList) {
    }
    
    /**
     * This method prefetches the viewBinding based on the layoutId mentioned the [prefetchViewTypeList].
     * and stores them into [prefetchItemBindingMap]
     */
    public final void prefetchItemBinding(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
    }
    
    /**
     * This method prefetches the child viewBinding based on the layoutId mentioned the [prefetchChildViewTypeList].
     * and stores them into [prefetchItemBindingMap]
     */
    private final void prefetchChildItemBinding(androidx.databinding.ViewDataBinding parentViewBinding, int parentLayoutId) {
    }
    
    /**
     * Gives the perfected viewBinding based on the mentioned layoutId in the argument.
     * if the [prefetchItemBindingMap] is null or empty than
     * a new viewBinding will be initialized and returned.
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ViewDataBinding getPrefetchedItemBinding(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int layoutId) {
        return null;
    }
    
    /**
     * Call this method from adapter's onDetachedFromRecyclerView to stop making more ViewDataBinding.
     */
    public final void detachedFromRecyclerView() {
    }
    
    private final androidx.databinding.ViewDataBinding initItemBinding(android.view.ViewGroup parent, int layoutId) {
        return null;
    }
    
    private final void initAsyncItemBinding(android.view.ViewGroup parent, int layoutId, int count) {
    }
}