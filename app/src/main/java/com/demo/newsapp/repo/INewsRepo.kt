package com.demo.newsapp.repo

import com.demo.newsapp.model.NewsEntity

interface INewsRepo {

    suspend fun getBreakingNews() : List<NewsEntity>
}