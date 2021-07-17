package com.demo.newsapp.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.demo.newsapp.R
import com.demo.newsapp.base.BaseActivity
import com.demo.newsapp.databinding.ActivityNewsBinding
import com.demo.newsapp.utils.logd
import com.demo.newsapp.utils.logi
import com.demo.newsapp.viewmodel.NewsViewModel

class NewsActivity : AppCompatActivity() {

    private val newsVm by viewModels<NewsViewModel>()
    private val layout by lazy { ActivityNewsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.new_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        layout.bottomNav.setupWithNavController(navController)
        NavigationUI.setupWithNavController(layout.bottomNav, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(layout.newNavHost).navigateUp()
    }
}