package com.demo.newsapp.network.api

import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.BannerResp
import com.demo.newsapp.network.entity.PublicTabListResp
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NewsApi {

    @GET("wxarticle/chapters/json")
    suspend fun getChapters(): PublicTabListResp

    @GET("wxarticle/list/{chapterId}/{page}/json?k=Java")
    suspend fun getChapterArticles(
        @Path("chapterId") chapterId: Int,
        @Path("page") page: Int
    ): ArticleListResp

    @GET("article/list/{page}/json")
    suspend fun getHomePageArticles(
        @Path("page") page: Int
    ): ArticleListResp

    @GET("banner/json")
    suspend fun getHomeBanners(): BannerResp

    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") rePassword: String
    ): String

    @GET("user/logout/json")
    suspend fun logout(): String

    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): String
}