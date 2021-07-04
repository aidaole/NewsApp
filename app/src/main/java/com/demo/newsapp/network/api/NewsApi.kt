package com.demo.newsapp.network.api

import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.network.entity.Resp
import retrofit2.http.GET

interface NewsApi {

    @GET("wxarticle/chapters/json")
    suspend fun getChapters(): Resp<Chapter>
}