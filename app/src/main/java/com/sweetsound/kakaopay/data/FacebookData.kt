package com.sweetsound.kakaopay.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class FacebookData (
        @SerializedName("message") val message: String,
        @SerializedName("created_time") private val _createdTime: String,
        @SerializedName("id") val id: String,
        @SerializedName("attachments") val attachments: Attachments
) {
    val createTime: String
        get() {
            return _createdTime.substring(0, 10)
        }
}