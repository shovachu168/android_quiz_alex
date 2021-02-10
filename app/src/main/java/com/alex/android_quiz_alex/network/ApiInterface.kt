package com.alex.android_quiz_alex.network

import com.alex.android_quiz_alex.dataModel.UserListResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search/users?q=repos")
    fun getUsersList(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Call<UserListResponseModel>

}