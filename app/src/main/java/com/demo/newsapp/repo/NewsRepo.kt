package com.demo.newsapp.repo

import com.demo.newsapp.local.db.DatabaseManager
import com.demo.newsapp.local.db.converters.UserConverter
import com.demo.newsapp.local.db.entity.User
import com.demo.newsapp.network.RetrofitManager
import com.demo.newsapp.network.entity.LoginResp
import com.demo.newsapp.network.entity.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class NewsRepo : INewsRepo {

    private val newsApi = RetrofitManager.newsApi()
    private val userDao = DatabaseManager.userDao()

    override suspend fun getChapters() =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.getChapters()
        }

    override suspend fun getChapterArticles(chapterId: Int, page: Int) =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.getChapterArticles(chapterId, page)
        }

    override suspend fun doLogin(username: String, password: String): LoginResp =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.login(username, password)
        }

    override suspend fun saveUserInfo(userinfo: UserInfo): User? = withContext(Dispatchers.IO) {
        val user = UserConverter().userInfoToUser(userinfo)
        if (userDao.saveUser(user) > 0) {
            return@withContext user
        }
        return@withContext null
    }

    override suspend fun getUserInfo(userId: Int): User? = withContext(Dispatchers.IO) {
        return@withContext userDao.getUser(userId)
    }
}