package com.kindredtask

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageBindingAdapterKt {
    @BindingAdapter("bind:imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        url.isNullOrBlank().let {
            Picasso.with(imageView.context).load(url)
                    .resize(100, 100).into(imageView)
        }
    }
}