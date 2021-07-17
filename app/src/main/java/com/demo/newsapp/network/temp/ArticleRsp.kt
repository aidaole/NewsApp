package com.demo.newsapp.network.temp

data class ArticleRsp(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)