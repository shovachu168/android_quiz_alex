package com.alex.android_quiz_alex.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alex.android_quiz_alex.R
import com.alex.android_quiz_alex.network.ApiService
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserDetailsFragment: Fragment() {

    private lateinit var infoView: LinearLayout
    private lateinit var nameView: LinearLayout
    private lateinit var idView: LinearLayout
    private lateinit var locationView: LinearLayout
    private lateinit var blogView: LinearLayout
    private lateinit var bioView: LinearLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var userImg: ImageView
    private lateinit var userName: TextView
    private lateinit var userID: TextView
    private lateinit var userLocation: TextView
    private lateinit var userBlog: TextView
    private lateinit var userBio: TextView
    private lateinit var mContext: Context
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.user_details_layout, container, false)
        infoView = view.findViewById(R.id.infoLayouts)
        nameView = view.findViewById(R.id.name_area)
        idView = view.findViewById(R.id.id_area)
        locationView = view.findViewById(R.id.location_area)
        blogView = view.findViewById(R.id.blog_area)
        bioView = view.findViewById(R.id.bio_area)
        progressBar = view.findViewById(R.id.loading_progress)
        userImg = view.findViewById(R.id.user_img)
        userName = view.findViewById(R.id.user_real_name)
        userID = view.findViewById(R.id.user_id)
        userLocation = view.findViewById(R.id.user_location)
        userBlog = view.findViewById(R.id.user_blog)
        userBio = view.findViewById(R.id.user_blo)
        mContext = this.requireContext()
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let { bundle ->
            bundle.getString("login")?.let {
                ApiService.sp.getUserDetailInfo(
                    it, success = { info ->
                        infoView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Glide.with(mContext)
                            .load(info.avatarUrl)
                            .apply(RequestOptions.circleCropTransform())
                            .into(userImg)
                        nameView.visibility = if (info.name == null || info.name.isEmpty()) View.GONE else View.VISIBLE
                        userName.text = info.name
                        idView.visibility = if (info.login == null || info.login.isEmpty()) View.GONE else View.VISIBLE
                        userID.text = info.login
                        locationView.visibility = if (info.location == null || info.location.isEmpty()) View.GONE else View.VISIBLE
                        userLocation.text = info.location
                        blogView.visibility = if (info.blog == null || info.blog.isEmpty()) View.GONE else View.VISIBLE
                        userBlog.text = info.blog
                        bioView.visibility = if (info.bio == null || info.bio.isEmpty()) View.GONE else View.VISIBLE
                        userBio.text = info.bio
                    }, failure = {
                    })
            }
        }
    }
}