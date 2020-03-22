package com.sweetsound.kakaopay.databinding

import android.app.Activity
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.sweetsound.kakaopay.Utils.loadUrl

@BindingAdapter(value = ["activity", "image_url"])
fun loadImage(imageView: ImageView, activity: Activity, url: String) {
    imageView.loadUrl(activity, url)
}

@BindingAdapter(value = ["requestManager", "image_url"])
fun loadImage(imageView: ImageView, glideRequestManager: RequestManager, url: String) {
    imageView.loadUrl(glideRequestManager, url)
}