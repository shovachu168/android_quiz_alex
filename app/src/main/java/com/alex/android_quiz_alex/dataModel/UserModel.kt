package com.alex.android_quiz_alex.dataModel

import com.google.gson.annotations.SerializedName


data class UserModel(
    @SerializedName("id") var id: Long,
    @SerializedName("login") var login: String,
    @SerializedName("site_admin") var siteAdmin: Boolean,
)