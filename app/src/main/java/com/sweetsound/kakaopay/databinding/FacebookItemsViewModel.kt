package com.sweetsound.kakaopay.databinding

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.HttpMethod
import com.google.gson.Gson
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.data.FacebookData
import com.sweetsound.kakaopay.net.FacebookRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacebookItemsViewModel(val context: Context) {
    private lateinit var facebookItemsModel: FacebookItemsModel
    val facebookItems: MutableLiveData<MutableList<FacebookData>> by lazy {
        MutableLiveData<MutableList<FacebookData>>().apply {
            value = mutableListOf()
        }
    }

    fun setModel(model: FacebookItemsModel) {
        facebookItemsModel = model
    }

    fun loadFacebookList() {
        facebookItemsModel.loadFacebookList(object : Callback<Facebook> {
                    override fun onFailure(call: Call<Facebook>, t: Throwable) {
                        Toast.makeText(context, R.string.response_fail, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Facebook>, response: Response<Facebook>) {
                        if (response.isSuccessful == true) {
                            response.body()?.apply {
                                val items = facebookItems.value as MutableList<FacebookData>
                                items.clear()
                                items.addAll(facebookDatas)
                                facebookItems.postValue(items)
                            }
                        }
                    }
                })
    }
}