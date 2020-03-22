package com.sweetsound.kakaopay.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attachments(
        @SerializedName("data") val attachmentDatas: List<AttachmentData>
) : Parcelable