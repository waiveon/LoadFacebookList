package com.sweetsound.kakaopay.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.data.FacebookData
import com.sweetsound.kakaopay.databinding.ActivityMainListItemBinding
import com.sweetsound.kakaopay.databinding.FacebookViewModel
import com.sweetsound.kakaopay.ui.DetailActivity
import com.sweetsound.kakaopay.ui.DetailActivity.Companion.MODEL
import kotlinx.android.synthetic.main.abc_popup_menu_item_layout.view.*


class FaceBookListAdapter(val glideRequestManager: RequestManager) : RecyclerView.Adapter<FaceBookListAdapter.ItemViewHolder>() {
    var items: MutableList<FacebookData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.activity_main_list_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ItemViewHolder(private val binding: ActivityMainListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: FacebookData) {
            val facebookViewModel = FacebookViewModel(data.message?.let { it } ?: "",
                    data.createTime,
                    data.attachments.attachmentDatas[0].media?.let {
                        it.image.src
                    } ?: "")

            binding.facebookViewModel = facebookViewModel
            binding.requestManager = glideRequestManager

            binding.root.setOnClickListener {
                val intent = Intent(itemView.getContext(), DetailActivity::class.java)
                intent.putExtra(MODEL, facebookViewModel)
                it.context.startActivity(intent)
            }
        }
    }
}