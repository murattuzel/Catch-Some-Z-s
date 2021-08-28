package com.murattuzel.catchsomezs.internal.databinding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleIf")
fun View.visibleIf(shouldVisible: Boolean) {
    visibility = if (shouldVisible) View.VISIBLE else View.GONE
}
