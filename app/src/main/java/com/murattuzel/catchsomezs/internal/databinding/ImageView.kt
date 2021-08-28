package com.murattuzel.catchsomezs.internal.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("loadImageUrl",)
fun ImageView.loadImageUrl(url: String?) {
    if (url != null) {
        load(url) {
            crossfade(true)
            transformations(RoundedCornersTransformation(8f))
        }
    }
}
