package com.demo.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.newsapp.R

class UserRegisterFragment : Fragment(R.layout.fragment_register) {

    companion object {
        fun create(bundle: Bundle): UserRegisterFragment {
            return UserRegisterFragment().apply {
                arguments = bundle
            }
        }
    }
}