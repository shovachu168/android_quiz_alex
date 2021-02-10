package com.alex.android_quiz_alex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.alex.android_quiz_alex.data.UsersItemDataSource
import com.alex.android_quiz_alex.network.ApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationController()
    }

    private fun setNavigationController() {
        val navController = Navigation.findNavController(this, R.id.root_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.fragment_navigation_path).navigateUp()
}