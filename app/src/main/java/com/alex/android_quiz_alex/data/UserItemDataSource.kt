package com.alex.android_quiz_alex.data


import androidx.paging.PageKeyedDataSource
import com.alex.android_quiz_alex.dataModel.UserModel


class UsersItemDataSource(): PageKeyedDataSource<Int, UserModel>() {

    companion object{
        const val PAGE_SIZE = 15
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UserModel>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {

    }
}