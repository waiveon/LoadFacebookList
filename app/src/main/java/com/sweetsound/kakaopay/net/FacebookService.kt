package com.sweetsound.kakaopay.net

import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FacebookService {
    @GET("v6.0/1556379761203984/feed")
    fun requestPostList(
            @Query("fields") fields: String,
            @Query("access_token") accessToken: String
    ) : Call<Facebook>

    @GET("v6.0/me")
    fun requestUser(
            @Query("fields") fields: String,
            @Query("access_token") accessToken: String
    ) : Call<User>
}