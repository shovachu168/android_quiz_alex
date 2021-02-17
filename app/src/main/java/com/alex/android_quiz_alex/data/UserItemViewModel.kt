package com.alex.android_quiz_alex.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.alex.android_quiz_alex.dataModel.UserModel

class UsersListViewModel: ViewModel() {
    lateinit var usersLiveData: LiveData<PagedList<UserModel>>
    var liveData: MutableLiveData<UsersItemDataSource> = MutableLiveData()

    init {
        initUsersListFactory()
    }

    private fun initUsersListFactory() {
        val itemDataSourceFactory = UsersDataSourceFactory()
        liveData = itemDataSourceFactory.liveData
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(UsersItemDataSource.PAGE_SIZE)
            .setPageSize(UsersItemDataSource.PAGE_SIZE)
            .setPrefetchDistance(3)
            .build()
        usersLiveData = LivePagedListBuilder(itemDataSourceFactory, config).build()
    }
}