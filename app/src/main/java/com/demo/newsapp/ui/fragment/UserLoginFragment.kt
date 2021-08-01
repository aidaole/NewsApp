package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.demo.newsapp.R
import com.demo.newsapp.databinding.FragmentLoginBinding
import com.demo.newsapp.ui.activity.MainActivity
import com.demo.newsapp.utils.toast
import com.demo.newsapp.viewmodel.UserViewModel

class UserLoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var layout: FragmentLoginBinding
    private val vm: UserViewModel by activityViewModels()

    companion object {
        fun create(bundle: Bundle): UserLoginFragment {
            return UserLoginFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentLoginBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        layout.btnLogin.setOnClickListener {
            val username = layout.etUsername.text.toString()
            val password = layout.etPassword.text.toString()
            vm.login(username, password)
        }
    }

    private fun initVm() {
        vm.loginResp.observe(viewLifecycleOwner) { resp ->
            if (resp == null || resp.errorCode != 0) {
                if (resp.errorCode == UserViewModel.ERR_USER_SAVE) {
                    "保存用户数据失败! ".toast(Toast.LENGTH_SHORT)
                } else {
                    "登录失败! Error: ${resp.errorMsg}".toast(Toast.LENGTH_SHORT)
                }
            } else {
                (activity as MainActivity).navToMainFragment()
            }
        }
    }
}