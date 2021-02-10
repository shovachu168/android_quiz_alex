package com.alex.android_quiz_alex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alex.android_quiz_alex.R

class UserDetailsFragment() : Fragment() {

    lateinit var userNameView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.user_details_layout, container, false)
        userNameView = view.findViewById<TextView>(R.id.login_name)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            userNameView.text = "The user is " + it.getString("login")
        }
    }
}