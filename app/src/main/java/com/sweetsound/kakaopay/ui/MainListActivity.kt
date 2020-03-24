package com.sweetsound.kakaopay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {
    val mFacebookItemsModel = FacebookItemsModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainListBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_list)
        binding.facebookItemsModel = mFacebookItemsModel
        binding.activity = this

        list_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list_recyclerview.adapter = FaceBookListAdapter(Glide.with(this@MainListActivity))

        loadFacebookList()
    }

    fun loadFacebookList() {
        val parameters = Bundle()
        parameters.putString("fields", "attachments,message,created_time")

        val accessToken = AccessToken(getString(R.string.facebook_access_token), getString(R.string.facebook_app_id), "1556379761203984", null, null, null, null, null)

        val graphRequest = GraphRequest(accessToken,
                "/${accessToken.getUserId()}/feed",
                null,
                HttpMethod.GET,
                object : GraphRequest.Callback {
                    override fun onCompleted(response: GraphResponse?) {
                        response?.let {
                            Gson().fromJson(it.rawResponse, Facebook::class.java).apply {
                                mFacebookItemsModel.facebookItems.clear()
                                mFacebookItemsModel.facebookItems.addAll(facebookDatas)
                            }
                        }
                    }
                })

        graphRequest.parameters = parameters
        graphRequest.executeAsync()
    }
}
