package com.alex.android_quiz_alex.dataModel

import com.google.gson.annotations.SerializedName


data class UserListResponseModel(
    @SerializedName("total_count") var totalCount: Int,
    @SerializedName("incomplete_results") var incompleteResults: Boolean,
    @SerializedName("items") var items: List<UserModel>
)

data class UserModel(
    @SerializedName("id") var id: Long,
    @SerializedName("login") var login: String,
    @SerializedName("site_admin") var siteAdmin: Boolean,
    @SerializedName("avatar_url") var avatarUrl: String,
)