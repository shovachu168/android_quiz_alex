package com.alex.android_quiz_alex.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.alex.android_quiz_alex.dataModel.UserModel

class UsersDataSourceFactory: DataSource.Factory<Int, UserModel>() {

    val liveData: MutableLiveData<UsersItemDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, UserModel> {
        val usersListDataSource = UsersItemDataSource()
        liveData.postValue(usersListDataSource)
        return usersListDataSource
    }
}