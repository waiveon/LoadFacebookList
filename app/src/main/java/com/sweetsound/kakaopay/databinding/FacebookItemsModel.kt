package com.sweetsound.kakaopay.databinding

import android.widget.Toast
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.net.FacebookRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacebookItemsModel {
    private lateinit var accessToken: String
    private lateinit var queryFields: String

    fun setFacebookAccessToken(token: String) {
        accessToken = token
    }

    fun setQueryFields(fields : String) {
        queryFields = fields
    }

    fun loadFacebookList(callback: Callback<Facebook>) {
        FacebookRetrofit.getService()
                .requestPostList(queryFields, accessToken)
                .enqueue(callback)
    }
}