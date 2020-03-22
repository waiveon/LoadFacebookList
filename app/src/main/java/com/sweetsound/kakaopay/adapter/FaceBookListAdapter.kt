package com.sweetsound.kakaopay.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.Utils.loadUrl
import com.sweetsound.kakaopay.data.FacebookData
import com.sweetsound.kakaopay.databinding.ActivityMainListItemBinding
import com.sweetsound.kakaopay.databinding.FacebookModel
import com.sweetsound.kakaopay.ui.DetailActivity
import com.sweetsound.kakaopay.ui.DetailActivity.Companion.MODEL


class FaceBookListAdapter(private val faceBookDatas: List<FacebookData>, val glideRequestManager: RequestManager) : RecyclerView.Adapter<FaceBookListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.activity_main_list_item, parent, false))
    }

    override fun getItemCount() = faceBookDatas.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(faceBookDatas[position])
    }

    inner class ItemViewHolder(private val binding: ActivityMainListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: FacebookData) {
            val facebookModel = FacebookModel(data.message?.let { it } ?: "",
                    data.createTime,
                    data.attachments.attachmentDatas[0].media?.let {
                        it.image.src
                    } ?: "")

            with(binding) {
                model = facebookModel
                requestManager = glideRequestManager
            }

            binding.root.setOnClickListener {
                val intent = Intent(itemView.getContext(), DetailActivity::class.java)
                intent.putExtra(MODEL, facebookModel)
                it.context.startActivity(intent)
            }
        }
    }

//    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.activity_main_list_item, parent, false)) {
//        fun bind(data: FacebookData) {
//            Log.e("TAG", "LJS== data : " + data)
//            val intent = Intent(itemView.getContext(), DetailActivity::class.java)
//
//            intent.putExtra(IMAGE_URL, data.attachments.attachmentDatas[0].media?.let {
//                itemView.attach_imageview.visibility = View.VISIBLE
//                itemView.attach_imageview.loadUrl(glideRequestManager, it.image.src)
//
//                it.image.src
//            } ?: "")
//
//            intent.putExtra(MESSAGE, data.message?.let {
//                itemView.message_textview.text = it
//                it
//            } ?: "")
//
//            itemView.date_textview.text = data.createTime
//
//            itemView.setOnClickListener {
//                intent.putExtra(CREATE_TIME, data.createTime)
//                it.context.startActivity(intent)
//            }
//        }
//    }
}