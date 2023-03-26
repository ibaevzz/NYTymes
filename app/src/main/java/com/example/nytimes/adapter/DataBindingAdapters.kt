package com.example.nytimes.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.with(view.context)
        .load(imageUrl)
        .into(view)
}