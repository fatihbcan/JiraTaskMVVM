package com.example.jirataskmvvm.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jirataskmvvm.R

fun ImageView.loadImage(uri: String?){
    val options = RequestOptions()
        .error(R.drawable.background1)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}