package com.alex.android_quiz_alex.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.android_quiz_alex.R
import com.alex.android_quiz_alex.data.UsersListViewModel
import com.alex.android_quiz_alex.dataModel.UserModel

class UserListFragment: Fragment(), UserItemAdapter.ItemClickCallback {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.list_user_layout, container, false)
        val context = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.user_item_list)
        var progressBar = view.findViewById<ProgressBar>(R.id.loading_progress)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val adapter = UserItemAdapter(this)
        val itemViewModel = ViewModelProvider(requireActivity()).get(UsersListViewModel::class.java)
        itemViewModel.usersLiveData.observe(viewLifecycleOwner, { items ->
            adapter.submitList(items)
        })
        itemViewModel.liveData.observe(viewLifecycleOwner, {
            it.isLoadingStatus.observe(viewLifecycleOwner, { loadStatus ->
                progressBar.visibility = if (loadStatus) View.VISIBLE else View.GONE
            })
        })
        recyclerView.adapter = adapter
        return view
    }

    override fun onItemClick(userModel: UserModel) {
        val direction = UserListFragmentDirections.goToDetailPage(userModel.login)
        findNavController().navigate(direction)
    }
}