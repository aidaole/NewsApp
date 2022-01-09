package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.newsapp.R
import com.demo.newsapp.base.FragmentNavigator
import com.demo.newsapp.databinding.FragmentMainContentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var layout: FragmentMainContentBinding
    private val fragmentNav by lazy {
        FragmentNavigator(
            parentFragmentManager,
            R.id.nav_host_container
        )
    }

    companion object {
        @JvmStatic
        fun create(bundle: Bundle): MainFragment {
            return MainFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentMainContentBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.bottomNav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemReselectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemReselected(item: MenuItem) {
            }

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu_home -> {
                        showFragment(HomePageFragment::class.java) {
                            HomePageFragment.create(Bundle())
                        }
                    }
                    R.id.menu_public_tab -> {
                        showFragment(PublicTabFragment::class.java) {
                            PublicTabFragment.create(Bundle())
                        }
                    }
                    R.id.menu_search -> {
                        showFragment(SearchNewsFragment::class.java) {
                            SearchNewsFragment.create(Bundle())
                        }
                    }
                    R.id.menu_user -> {
                        showFragment(UserFragment::class.java) {
                            UserFragment.create(Bundle())
                        }
                    }
                }
                return true
            }
        })
        showFragment(HomePageFragment::class.java) {
            HomePageFragment.create(Bundle())
        }
    }

    private fun <T> showFragment(clz: Class<T>, createFragment: () -> Fragment) {
        fragmentNav.findFragment(clz)?.run {
            fragmentNav.show(this)
        } ?: run {
            fragmentNav.show(createFragment())
        }
    }
}