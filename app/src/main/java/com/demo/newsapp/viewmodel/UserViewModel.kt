package com.demo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.local.db.entity.User
import com.demo.newsapp.network.entity.LoginResp
import com.demo.newsapp.network.entity.UserInfo
import com.demo.newsapp.repo.NewsRepo
import com.demo.newsapp.utils.Sp
import com.demo.newsapp.utils.logd
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    companion object {
        const val ERR_USER_SAVE = -2
        const val LAST_LOGIN_USER_ID = "last_login_user_id"
    }

    private val repo by lazy { NewsRepo() }
    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user
    private val _loginResp = MutableLiveData<LoginResp>()
    val loginResp
        get() = _loginResp
    private val _registResp = MutableLiveData<LoginResp>()
    val registResp
        get() = _registResp

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = repo.doLogin(username, password)
            if (result.errorCode == 0 && result.data != null) {
                _user.value = saveUser(result)
            } else {
                _user.value = null
            }
            _loginResp.value = result
        }
    }

    fun register(username: String, password: String, repassword: String) {
        viewModelScope.launch {
            val result = repo.doRegister(username, password, repassword)
            if (result.errorCode == 0 && result.data != null) {
                _user.value = saveUser(result)
            } else {
                _user.value = null
            }
            _registResp.value = result
        }
    }

    fun loadUserInfo() {
        viewModelScope.launch {
            val lastLoginUserId = Sp.getInt(LAST_LOGIN_USER_ID)
            repo.getUserInfo(lastLoginUserId)?.let {
                "加载上一次登录用户成功${it.nickname}".logd()
                _user.value = it
            }
        }
    }

    private suspend fun saveUser(result: LoginResp):User? {
        val savedUser = repo.saveUserInfo(result.data!!)
        if (savedUser == null) {
            result.errorCode = ERR_USER_SAVE
        } else {
            Sp.saveInt(LAST_LOGIN_USER_ID, savedUser.id)
        }
        return savedUser
    }
}