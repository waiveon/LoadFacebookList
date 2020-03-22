package com.sweetsound.kakaopay.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.Utils.loadUrl
import com.sweetsound.kakaopay.data.FacebookData
import com.sweetsound.kakaopay.ui.DetailActivity
import com.sweetsound.kakaopay.ui.DetailActivity.Companion.CREATE_TIME
import com.sweetsound.kakaopay.ui.DetailActivity.Companion.IMAGE_URL
import com.sweetsound.kakaopay.ui.DetailActivity.Companion.MESSAGE
import kotlinx.android.synthetic.main.activity_main_list_item.view.*


class FaceBookListAdapter(private val faceBookDatas: List<FacebookData>) : RecyclerView.Adapter<FaceBookListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount() = faceBookDatas.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(faceBookDatas[position])
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main_list_item, parent, false)) {
        fun bind(data: FacebookData) {
            Log.e("TAG", "LJS== data : " + data)
            val intent = Intent(itemView.getContext(), DetailActivity::class.java)

            data.attachments.attachmentDatas[0].media?.let {
                itemView.attach_imageview.visibility = View.VISIBLE
                itemView.attach_imageview.loadUrl(it.image.src)

                intent.putExtra(IMAGE_URL, it.image.src)
            }
            data.message?.let {
                itemView.message_textview.text = it

                intent.putExtra(MESSAGE, it)
            }
            itemView.date_textview.text = data.createTime

            itemView.setOnClickListener {
                intent.putExtra(CREATE_TIME, data.createTime)
                it.context.startActivity(intent)
            }
        }
    }
}