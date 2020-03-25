package com.sweetsound.kakaopay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.HttpMethod
import com.google.gson.Gson
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.adapter.FaceBookListAdapter
import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.databinding.ActivityMainListBinding
import com.sweetsound.kakaopay.databinding.FacebookItemsModel
import com.sweetsound.kakaopay.databinding.FacebookItemsViewModel
import com.sweetsound.kakaopay.net.FacebookRetrofit
import kotlinx.android.synthetic.main.abc_popup_menu_item_layout.*
import kotlinx.android.synthetic.main.activity_main_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val facebookItemsViewModel = FacebookItemsViewModel(this)

        val binding: ActivityMainListBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_list)
        binding.facebookItemsViewModel = facebookItemsViewModel
        binding.setLifecycleOwner(this)

        list_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list_recyclerview.adapter = FaceBookListAdapter(Glide.with(this@MainListActivity))

        FacebookItemsModel().also {facebookItemsModel ->
            facebookItemsModel.setFacebookAccessToken(getString(R.string.facebook_access_token))
            facebookItemsModel.setQueryFields("attachments,message,created_time")

            with(facebookItemsViewModel) {
                setModel(facebookItemsModel)
                loadFacebookList()
            }
        }


//        with(FacebookItemsModel()) {facebookItemsModel ->
//            setFacebookAccessToken(getString(R.string.facebook_access_token))
//            setQueryFields("attachments,message,created_time")
//
//            with(facebookItemsViewModel) {
//                setModel()
//            }
//        }



//        with(facebookItemsViewModel) {
//            setFacebookAccessToken(getString(R.string.facebook_access_token))
//            setQueryFields("attachments,message,created_time")
//            loadFacebookList()
//        }
    }
}
