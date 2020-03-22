package com.sweetsound.kakaopay.Utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.sweetsound.kakaopay.R

fun ImageView.loadUrl(activity: Activity, url: String) {
    procGlide(Glide.with(activity), url, this)
}

fun ImageView.loadUrl(glideRequestManager: RequestManager, url: String) {
    procGlide(glideRequestManager, url, this)
}

private fun procGlide(glideRequestManager: RequestManager, url: String, imgaeView: ImageView) {
    if (url.isEmpty() == true) {
        imgaeView.visibility = View.GONE
    } else {
        imgaeView.visibility = View.VISIBLE
        glideRequestManager.load(url).error(R.drawable.safe_image).placeholder(R.drawable.safe_image).into(imgaeView)
    }

}