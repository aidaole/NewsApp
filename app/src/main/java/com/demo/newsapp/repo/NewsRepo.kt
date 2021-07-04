package com.demo.newsapp.repo

import com.demo.newsapp.network.api.NewsApi
import com.demo.newsapp.local.db.NewsDao
import com.demo.newsapp.model.NewsEntity
import com.demo.newsapp.network.RetrofitManager
import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.network.entity.Resp
import com.demo.newsapp.utils.loge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepo : INewsRepo {

    private val newsApi = RetrofitManager.newsApi()

    override suspend fun getChapters() =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.getChapters()
        }
}