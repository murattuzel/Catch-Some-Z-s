package com.murattuzel.catchsomezs.internal.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.murattuzel.catchsomezs.R

@BindingAdapter("bannerText")
fun TextView.bannerText(name: String) {
    text = context.getString(R.string.home_banner_text, name)
}
