package com.sweetsound.kakaopay.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Image(
        @SerializedName("src") val src: String,
        @SerializedName("height") val height: Long,
        @SerializedName("width") val width: Long
)