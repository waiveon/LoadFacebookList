package com.sweetsound.kakaopay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.HttpMethod
import com.google.gson.Gson
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.adapter.FaceBookListAdapter
import com.sweetsound.kakaopay.data.Facebook
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        list_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val parameters = Bundle()
        parameters.putString("fields", "attachments,message,created_time")

        val accessToken = AccessToken(getString(R.string.facebook_access_token), getString(R.string.facebook_app_id), "1556379761203984", null, null, null, null, null)

        val graphRequest = GraphRequest(accessToken,
                "/" + accessToken.getUserId() + "/feed",
                null,
                HttpMethod.GET,
                object : GraphRequest.Callback {
                    override fun onCompleted(response: GraphResponse?) {
                        Log.e("TAG", "LJS== data : " + response?.rawResponse.toString())

                        response?.let {
                            val facebook = Gson().fromJson(it.rawResponse, Facebook::class.java)
                            list_recyclerview.adapter = FaceBookListAdapter(facebook.facebookDatas, Glide.with(this@MainListActivity))
                        }

                    }
                })

        graphRequest.parameters = parameters
        graphRequest.executeAsync()
    }
}
