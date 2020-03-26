package com.sweetsound.kakaopay.databinding

open class BaseModel {
    protected lateinit var accessToken: String
    protected lateinit var facebookQueryFields: String

    fun setFacebookAccessToken(token: String) {
        accessToken = token
    }

    fun setQueryFields(fields : String) {
        facebookQueryFields = fields
    }
}