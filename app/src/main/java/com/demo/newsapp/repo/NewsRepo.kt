package com.demo.newsapp.repo

import com.demo.newsapp.api.NewsApi
import com.demo.newsapp.db.NewsDao
import com.demo.newsapp.model.NewsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepo(
    var newsApi: NewsApi,
    var newsDao: NewsDao
) : INewsRepo {

    override suspend fun getBreakingNews(): List<NewsEntity> =
        withContext(Dispatchers.IO) {
            newsApi.getBreakingNews()
            listOf<NewsEntity>()
        }
}