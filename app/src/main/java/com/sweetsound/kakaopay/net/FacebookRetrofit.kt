package com.sweetsound.kakaopay.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FacebookRetrofit {
    // https://graph.facebook.com/v6.0/1556379761203984/feed?fields=attachments,message,created_time&access_token=EAADWQ5xdQrsBAOMyT78i79WFOQytsRtWcY3qNj9XZCZAwCq9YHMx18ZBYX5UugMZCwwsQlNrhu3zyPSQNZB4c7nVSmcIjt5ijZBSplgZCgbBq9pfMSA79rtqmXE8F3Ms9UZCguoxBlkwiEOscETGUKTXZAnBrJ7BpUQZAFrBr6l0XVgLJyha1MPYd9TXukAkUvgGUZD
    private val baseUrl = "https://graph.facebook.com/"
    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getService() : FacebookService = retrofit.create(FacebookService::class.java)
}