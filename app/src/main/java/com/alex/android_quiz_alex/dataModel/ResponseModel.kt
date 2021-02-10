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

data class UserDetailsModel(
    @SerializedName("id") var id: Long,
    @SerializedName("login") var login: String,
    @SerializedName("avatar_url") var avatarUrl: String,
    @SerializedName("gravatar_id") var gravatarId: String,
    @SerializedName("site_admin") var siteAdmin: Boolean,
    @SerializedName("name") var name: String,
    @SerializedName("blog") var blog: String,
    @SerializedName("location") var location: String,
    @SerializedName("bio") var bio: String,
)