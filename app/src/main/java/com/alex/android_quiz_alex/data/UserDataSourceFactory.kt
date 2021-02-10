package com.alex.android_quiz_alex.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.alex.android_quiz_alex.dataModel.UserModel

class UsersDataSourceFactory: DataSource.Factory<Int, UserModel>() {

    private val itemLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, UserModel>> = MutableLiveData()

    override fun create(): DataSource<Int, UserModel> {
        val usersListDataSource = UsersItemDataSource()
        itemLiveDataSource.postValue(usersListDataSource)
        return usersListDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, UserModel>> {
        return itemLiveDataSource
    }
}