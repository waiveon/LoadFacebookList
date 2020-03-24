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


class FaceBookListAdapter(val glideRequestManager: RequestManager) : RecyclerView.Adapter<FaceBookListAdapter.ItemViewHolder>() {
    var items: List<FacebookData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.activity_main_list_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
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
}