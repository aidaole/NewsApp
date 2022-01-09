package com.demo.newsapp.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.demo.newsapp.R
import com.demo.newsapp.base.FragmentNavigator
import com.demo.newsapp.databinding.ActivityMainBinding
import com.demo.newsapp.ui.fragment.MainFragment
import com.demo.newsapp.ui.fragment.UserLoginFragment
import com.demo.newsapp.ui.fragment.UserRegisterFragment
import com.demo.newsapp.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private val newsVm by viewModels<NewsViewModel>()
    private val layout by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragmentNav by lazy { FragmentNavigator(supportFragmentManager, R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.root)
        navToMainFragment()
    }

    override fun onBackPressed() {
        if (!fragmentNav.isCurMainFragment()) {
            navToMainFragment()
        } else {
            super.onBackPressed()
        }
    }

    fun navToMainFragment() = navToFragment(MainFragment::class.java) {
        MainFragment.create(Bundle())
    }

    fun navToLoginFragment() = navToFragment(UserLoginFragment::class.java) {
        UserLoginFragment.create(Bundle())
    }

    fun navToRegisterFragment() = navToFragment(UserRegisterFragment::class.java) {
        UserRegisterFragment.create(Bundle())
    }

    private fun <T> navToFragment(clazz: Class<T>, createFragment: () -> Fragment) {
        fragmentNav.findFragment(clazz)?.run {
            fragmentNav.show(this)
        } ?: run {
            fragmentNav.show(createFragment())
        }
    }
}