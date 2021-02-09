package com.alex.android_quiz_alex.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alex.android_quiz_alex.R
import com.alex.android_quiz_alex.dataModel.UserModel

class UserItemAdapter(): PagedListAdapter<UserModel, UserItemAdapter.UsersListViewHolder>(
    usersDiffCallback
) {

    private lateinit var mContext: Context

    inner class UsersListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item: LinearLayout = itemView.findViewById(R.id.user)
        val userImg: ImageView = itemView.findViewById(R.id.user_img)
        val userName: AppCompatTextView = itemView.findViewById(R.id.user_name)
        val admin: AppCompatTextView = itemView.findViewById(R.id.site_admin)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        val githubUserModel = getItem(position)
        githubUserModel?.let {
            holder.userName.text = it.login
            holder.admin.visibility = if (it.siteAdmin) View.VISIBLE else View.INVISIBLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.user_item, parent, false)
        return UsersListViewHolder(view)
    }

    companion object {
        val usersDiffCallback = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}