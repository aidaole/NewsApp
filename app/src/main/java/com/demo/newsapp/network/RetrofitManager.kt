package com.demo.newsapp.network

import com.demo.newsapp.network.api.WanApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    private const val BASE_URL = "https://www.wanandroid.com"
    private val retrofit: Retrofit
    private val okhttpClient: OkHttpClient

    init {
        okhttpClient = buildOkHttpClient()
        retrofit = buildRetrofit()
    }

    private fun buildOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .build()

    private fun buildRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(StringConverterFactory)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun newsApi() = retrofit.create(WanApi::class.java)
}