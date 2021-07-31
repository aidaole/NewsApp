package com.demo.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.newsapp.R

class UserLoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        fun create(bundle: Bundle): UserLoginFragment {
            return UserLoginFragment().apply {
                arguments = bundle
            }
        }
    }
}