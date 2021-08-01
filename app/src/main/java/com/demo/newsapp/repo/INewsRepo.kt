package com.demo.newsapp.repo

import com.demo.newsapp.local.db.entity.User
import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.LoginResp
import com.demo.newsapp.network.entity.PublicTabListResp
import com.demo.newsapp.network.entity.UserInfo

interface INewsRepo {

    suspend fun getChapters(): PublicTabListResp
    suspend fun getChapterArticles(chapterId: Int, page: Int): ArticleListResp
    suspend fun doLogin(username: String, password: String): LoginResp
    suspend fun saveUserInfo(userinfo: UserInfo): User?
    suspend fun getUserInfo(userId: Int): User?
}