package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.demo.newsapp.R
import com.demo.newsapp.databinding.FragmentUserBinding
import com.demo.newsapp.ui.activity.MainActivity
import com.demo.newsapp.utils.toGone
import com.demo.newsapp.utils.toVisible
import com.demo.newsapp.viewmodel.UserViewModel

class UserFragment : Fragment(R.layout.fragment_user) {

    private lateinit var layout: FragmentUserBinding
    private val userVm by activityViewModels<UserViewModel>()

    companion object {
        const val KEY_DEST = "dest"
        const val DEST_LOGIN = "dest_login"
        const val DEST_REGISTER = "dest_register"

        fun create(bundle: Bundle): UserFragment {
            return UserFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentUserBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        layout.btnLogin.setOnClickListener {
            (activity as MainActivity).navToLoginFragment()
        }

        layout.btnRegister.setOnClickListener {
            (activity as MainActivity).navToRegisterFragment()
        }

        userVm.loadUserInfo()
    }

    private fun initVm() {
        userVm.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                layout.tvUsername.text = user.nickname
                layout.tvUsername.toVisible()
                layout.loginLayout.toGone()
            } else {
                layout.tvUsername.text = getString(R.string.not_login)
                layout.tvUsername.toGone()
                layout.loginLayout.toVisible()
            }
        }
    }
}