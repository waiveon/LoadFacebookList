package com.sweetsound.kakaopay.databinding

import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.net.FacebookRetrofit
import retrofit2.Callback

class FacebookItemsModel() : BaseModel() {
    fun loadFacebookList(callback: Callback<Facebook>) {
        FacebookRetrofit.getService()
                .requestPostList(facebookQueryFields, accessToken)
                .enqueue(callback)
    }
}