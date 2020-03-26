package com.sweetsound.kakaopay.databinding

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.sweetsound.kakaopay.R
import com.sweetsound.kakaopay.data.Facebook
import com.sweetsound.kakaopay.data.FacebookData
import com.sweetsound.kakaopay.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(val context: Context) {
    private lateinit var userModel: UserModel
    val userName: MutableLiveData<String> = MutableLiveData<String>()

    fun setModel(model: UserModel) {
        userModel = model
    }

    fun getUser() {
        userModel.getUser(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(context, R.string.response_fail, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful == true) {
                    response.body()?.apply {
                        userName.postValue(name)
                    }
                }
            }
        })
    }
}