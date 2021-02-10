package com.alex.android_quiz_alex.data


import androidx.paging.PageKeyedDataSource
import com.alex.android_quiz_alex.dataModel.UserModel
import com.alex.android_quiz_alex.network.ApiService


class UsersItemDataSource : PageKeyedDataSource<Int, UserModel>() {

    companion object {
        const val PAGE_SIZE = 15
        const val now_page = 1
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UserModel>
    ) {
        ApiService.sp.getUsersList(now_page, PAGE_SIZE, success = {
            callback.onResult(it.items, null, now_page + 1)
        }, failure = {
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {
        ApiService.sp.getUsersList(params.key, PAGE_SIZE, success = {
            callback.onResult(it.items,  params.key + 1)
        }, failure = {
        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {

    }
}