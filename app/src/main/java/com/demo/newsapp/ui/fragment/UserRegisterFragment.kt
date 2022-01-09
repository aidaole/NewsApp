package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.demo.newsapp.databinding.FragmentRegisterBinding
import com.demo.newsapp.network.entity.LoginResp
import com.demo.newsapp.ui.activity.MainActivity
import com.demo.newsapp.utils.toast
import com.demo.newsapp.viewmodel.UserViewModel

class UserRegisterFragment : Fragment() {

    private lateinit var layout: FragmentRegisterBinding
    private val vm: UserViewModel by activityViewModels()

    companion object {
        fun create(bundle: Bundle): UserRegisterFragment {
            return UserRegisterFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentRegisterBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        layout.btnRegister.setOnClickListener {
            val username = layout.etUsername.text.toString()
            val password = layout.etPassword.text.toString()
            val repassword = layout.etRepassword.text.toString()
            vm.register(username, password, repassword)
        }
    }

    private fun initVm() {
        vm.registResp.observe(viewLifecycleOwner) { resp ->
            doAfterRegister(resp)
        }
    }

    private fun doAfterRegister(resp: LoginResp) {
        if (resp.errorCode != 0) {
            if (resp.errorCode == UserViewModel.ERR_USER_SAVE) {
                "保存用户数据失败! ".toast(context = requireContext())
            } else {
                "注册失败! Error: ${resp.errorMsg}".toast(context = requireContext())
            }
        } else {
            (activity as MainActivity).navToMainFragment()
        }
    }
}