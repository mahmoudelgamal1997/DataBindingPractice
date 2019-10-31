package com.example.databindingpractice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import android.R
import com.bumptech.glide.request.RequestOptions



data class EmploeeModel(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)

