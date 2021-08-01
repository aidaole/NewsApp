package com.demo.newsapp.base

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.demo.newsapp.ui.fragment.HomePageFragment
import com.demo.newsapp.ui.fragment.MainFragment

class FragmentNavigator(
    private val fragmentManager: FragmentManager,
    private var containerId: Int
) {

    private var curFragment: Fragment? = null

    fun isCurMainFragment(): Boolean {
        return curFragment is MainFragment
    }

    fun findFragment(tag: String): Fragment? {
        return fragmentManager.findFragmentByTag(tag)
    }

    fun <T> findFragment(clazz: Class<T>): Fragment? {
        val tag = clazz.simpleName
        return findFragment(tag)
    }

    fun <T : Fragment> getFragment(bundle: Bundle, fragmentClz: Class<T>): T {
        var fragment = findFragment(fragmentClz)
        if (fragment == null) {
            val method = fragmentClz.getMethod("create", Bundle::class.java)
            fragment = method.invoke(null, bundle) as T
        }
        return fragment as T
    }

    fun show(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName
        show(tag, fragment)
    }

    fun show(tag: String, fragment: Fragment) {
        fragmentManager.beginTransaction().run {
            curFragment?.let { cur ->
                hide(cur)
            }
            findFragment(tag) ?: add(containerId, fragment, tag)
            show(fragment)
            commit()
            curFragment = fragment
        }
    }

    fun remove(){
        fragmentManager.fragments.size
    }
}