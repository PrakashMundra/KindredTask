package com.kindredtask;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (url != null && !url.trim().isEmpty()) {
            Picasso.with(imageView.getContext()).load(url)
                    .resize(100, 100).into(imageView);
        }
    }
}
