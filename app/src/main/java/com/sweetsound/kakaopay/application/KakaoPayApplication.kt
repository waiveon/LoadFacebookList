package com.sweetsound.kakaopay.application

import android.app.Application
import com.facebook.FacebookSdk

class KakaoPayApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        FacebookSdk.sdkInitialize(baseContext)
    }
}