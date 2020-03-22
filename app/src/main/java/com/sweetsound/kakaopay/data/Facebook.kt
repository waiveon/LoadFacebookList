package com.sweetsound.kakaopay.data

import com.google.gson.annotations.SerializedName

data class Facebook(
        @SerializedName("data") val facebookDatas: List<FacebookData>
)