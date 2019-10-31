package com.example.databindingpractice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

@BindingAdapter("avatar")
fun loadImage(img: ImageView, uri:String){
    Glide
        .with(img.context)
        .setDefaultRequestOptions(RequestOptions().circleCrop())
        .load(uri).into(img)
}

