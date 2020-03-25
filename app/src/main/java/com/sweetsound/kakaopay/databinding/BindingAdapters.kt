package com.sweetsound.kakaopay.databinding

import android.app.Activity
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.sweetsound.kakaopay.Utils.loadUrl
import com.sweetsound.kakaopay.adapter.FaceBookListAdapter
import com.sweetsound.kakaopay.data.FacebookData

@BindingAdapter(value = ["activity", "image_url"])
fun loadImage(imageView: ImageView, activity: Activity, url: String) {
    imageView.loadUrl(activity, url)
}

@BindingAdapter(value = ["requestManager", "image_url"])
fun loadImage(imageView: ImageView, glideRequestManager: RequestManager, url: String) {
    imageView.loadUrl(glideRequestManager, url)
}

@BindingAdapter("list_item")
//fun setListItem(recyclerView: RecyclerView, facebookItems: List<FacebookData>) {
////    (recyclerView.adapter as? FaceBookListAdapter)?.let {
////        it.items = facebookItems
////        it.notifyDataSetChanged()
////    }
//    (recyclerView.adapter as FaceBookListAdapter).apply {
//        items = facebookItems
//        notifyDataSetChanged()
//    }
//}
fun setListItem(recyclerView: RecyclerView, facebookItems: LiveData<MutableList<FacebookData>>) {
    (recyclerView.adapter as FaceBookListAdapter).apply {
        facebookItems.value?.let {
            items = it
        }
        notifyDataSetChanged()
    }
}