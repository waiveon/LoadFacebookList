package com.sweetsound.kakaopay.data

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Media(
        @SerializedName("image") val image: Image
)