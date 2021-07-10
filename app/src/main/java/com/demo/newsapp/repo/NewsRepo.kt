package com.demo.newsapp.repo

import com.demo.newsapp.network.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepo : INewsRepo {

    private val newsApi = RetrofitManager.newsApi()

    override suspend fun getChapters() =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.getChapters()
        }

    override suspend fun getChapterArticles(chapterId: Int, page: Int) =
        withContext(Dispatchers.IO) {
            return@withContext newsApi.getChapterArticles(chapterId, page)
        }

}