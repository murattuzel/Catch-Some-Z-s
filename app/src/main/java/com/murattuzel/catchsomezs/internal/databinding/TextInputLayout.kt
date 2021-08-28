package com.murattuzel.catchsomezs.internal.databinding

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("tilErrorMessage")
fun TextInputLayout.showError(
    @StringRes messageRes: Int?
) {
    error = messageRes?.let { context.getString(it) }
}
