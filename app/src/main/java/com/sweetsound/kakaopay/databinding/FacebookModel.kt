package com.sweetsound.kakaopay.databinding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FacebookModel(
        val message: String,
        val createTime: String,
        val imageUrl: String
) : Parcelable