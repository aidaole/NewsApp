package com.demo.newsapp.repo

import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.network.entity.Resp

interface INewsRepo {

    suspend fun getChapters(): Resp<Chapter>
}