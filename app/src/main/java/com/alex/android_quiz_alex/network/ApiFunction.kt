package com.alex.android_quiz_alex.network


import com.alex.android_quiz_alex.dataModel.UserModel

class ApiFunction(private val service: ApiInterface) {

    fun getUsersList(
        page: Int,
        pageSize: Int,
        success: Success<Array<UserModel>>,
        failure: FailureCallBack
    ) {
        service.getUsersList(page, pageSize).handleModel(success, failure)
    }
}