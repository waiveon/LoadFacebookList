package com.sweetsound.kakaopay.databinding

import com.sweetsound.kakaopay.data.User
import com.sweetsound.kakaopay.net.FacebookRetrofit
import retrofit2.Callback

class UserModel() : BaseModel() {
    fun getUser(callback: Callback<User>) {
        FacebookRetrofit.getService()
                .requestUser(facebookQueryFields, accessToken)
                .enqueue(callback)
    }
}