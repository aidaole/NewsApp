package com.demo.newsapp.network.api

import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.network.entity.ChapterListResp
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    @GET("wxarticle/chapters/json")
    suspend fun getChapters(): ChapterListResp

    @GET("wxarticle/list/{chapterId}/{page}/json?k=Java")
    suspend fun getChapterArticles(
        @Path("chapterId") chapterId: Int,
        @Path("page") page: Int
    ): ArticleListResp
}