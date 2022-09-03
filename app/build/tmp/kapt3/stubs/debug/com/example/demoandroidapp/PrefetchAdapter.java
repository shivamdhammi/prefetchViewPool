package com.example.demoandroidapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/demoandroidapp/PrefetchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/demoandroidapp/PrefetchViewHolder;", "()V", "list", "", "", "prefetchViewPool", "Lcom/example/demoandroidapp/PrefetchViewPool;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setData", "app_debug"})
public final class PrefetchAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.demoandroidapp.PrefetchViewHolder> {
    private final com.example.demoandroidapp.PrefetchViewPool prefetchViewPool = null;
    private java.util.List<java.lang.String> list;
    
    public PrefetchAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.demoandroidapp.PrefetchViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.demoandroidapp.PrefetchViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onDetachedFromRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
    }
}