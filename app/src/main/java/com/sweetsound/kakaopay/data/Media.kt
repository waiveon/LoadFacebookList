package com.sweetsound.kakaopay.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
        @SerializedName("image") val image: Image
) : Parcelable