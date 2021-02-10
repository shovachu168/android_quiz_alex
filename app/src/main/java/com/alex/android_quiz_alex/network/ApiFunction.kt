package com.alex.android_quiz_alex.network


import com.alex.android_quiz_alex.dataModel.UserDetailsModel
import com.alex.android_quiz_alex.dataModel.UserListResponseModel

class ApiFunction(private val service: ApiInterface) {
    fun getUsersList(
        page: Int,
        pageSize: Int,
        success: Success<UserListResponseModel>,
        failure: FailureCallBack
    ) {
        service.getUsersList(page, pageSize).handleModel(success, failure)
    }

    fun getUserDetailInfo(
        userName: String,
        success: Success<UserDetailsModel>,
        failure: FailureCallBack
    ) {
        service.getUserDetailInfo(userName).handleModel(success, failure)
    }
}