package com.sweetsound.kakaopay.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class AttachmentData(
        @SerializedName("media") val media: Media
)