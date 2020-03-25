package com.sweetsound.kakaopay.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sweetsound.kakaopay.R
import androidx.databinding.DataBindingUtil
import com.sweetsound.kakaopay.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    companion object {
        val MODEL = "MODEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.facebookViewModel = intent.getParcelableExtra(MODEL)
        binding.activity = this
    }
}