package com.demo.newsapp.network.api

import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.BannerResp
import com.demo.newsapp.network.entity.LoginResp
import com.demo.newsapp.network.entity.PublicTabListResp
import retrofit2.http.*

interface WanApi {

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

    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") rePassword: String
    ): LoginResp
    // {"data":null,"errorCode":-1,"errorMsg":"用户名已经被注册！"}
    // {"data":{"admin":false,"chapterTops":[],"coinCount":0,"collectIds":[],"email":"","icon":"","id":106960,"nickname":"testzhanghao123","password":"","publicName":"testzhanghao123","token":"","type":0,"username":"testzhanghao123"},"errorCode":0,"errorMsg":""}

    @GET("user/logout/json")
    suspend fun logout(): String

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResp
}