package com.alex.android_quiz_alex.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.android_quiz_alex.R
import com.alex.android_quiz_alex.data.UserItemAdapter
import com.alex.android_quiz_alex.data.UsersListViewModel

class UserListFragment : Fragment() {

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
        val itemViewModel: UsersListViewModel =
            of(this).get(UsersListViewModel::class.java)
        val adapter = UserItemAdapter()
        itemViewModel.usersLiveData.observe(viewLifecycleOwner,
            { items ->
                adapter.submitList(items)
                progressBar.visibility = View.GONE
            })
        recyclerView.adapter = adapter
        return view
    }

}