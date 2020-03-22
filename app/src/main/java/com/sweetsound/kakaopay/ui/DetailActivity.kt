package com.sweetsound.kakaopay.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.Utils.loadUrl
import com.sweetsound.kakaopay.data.FacebookData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val MESSAGE = "MESSAGE"
        val CREATE_TIME = "CREATE_TIME"
        val IMAGE_URL = "IMAGE_URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val message = intent.getStringExtra(MESSAGE)
        val createTime = intent.getStringExtra(CREATE_TIME)
        val imageUrl = intent.getStringExtra(IMAGE_URL)

        imageUrl?.let {
            attach_imageview.visibility = View.VISIBLE
            attach_imageview.loadUrl(it)
        }
        message?.let {
            message_textview.text = it
        }
        date_textview.text = createTime
    }
}