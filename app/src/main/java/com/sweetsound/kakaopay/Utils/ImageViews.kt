package com.sweetsound.kakaopay.Utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sweetsound.kakaopay.R

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).error(R.drawable.safe_image).placeholder(R.drawable.safe_image).into(this)
}