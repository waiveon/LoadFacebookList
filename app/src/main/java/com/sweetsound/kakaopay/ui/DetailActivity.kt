package com.sweetsound.kakaopay.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.Utils.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*
import androidx.databinding.DataBindingUtil
import com.sweetsound.kakaopay.databinding.ActivityDetailBinding
import com.sweetsound.kakaopay.databinding.FacebookModel


class DetailActivity : AppCompatActivity() {
    companion object {
        val MODEL = "MODEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
//        binding.facebookModel = FacebookModel(intent.getStringExtra(MESSAGE), intent.getStringExtra(CREATE_TIME), intent.getStringExtra(IMAGE_URL))
        binding.facebookModel = intent.getParcelableExtra(MODEL)
        binding.activity = this

//        setContentView(R.layout.activity_detail)
//
//        val message = intent.getStringExtra(MESSAGE)
//        val createTime = intent.getStringExtra(CREATE_TIME)
//        val imageUrl = intent.getStringExtra(IMAGE_URL)

//        imageUrl?.let {
//            attach_imageview.visibility = View.VISIBLE
//            attach_imageview.loadUrl(it)
//        }
//        message?.let {
//            message_textview.text = it
//        }
//        date_textview.text = createTime
    }
}