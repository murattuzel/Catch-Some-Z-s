package com.murattuzel.catchsomezs.internal.databinding

import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.murattuzel.catchsomezs.base.BaseListAdapter
import com.murattuzel.catchsomezs.base.ListAdapterItem

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun RecyclerView.submitList(list: List<ListAdapterItem>?) {
    val adapter = this.adapter as BaseListAdapter<ViewDataBinding, ListAdapterItem>?
    adapter?.submitList(list)
}

@BindingAdapter("adapter")
fun RecyclerView.setupAdapter(adapter: BaseListAdapter<ViewDataBinding, ListAdapterItem>?) {
    adapter?.let {
        this.adapter = it
    }
}
