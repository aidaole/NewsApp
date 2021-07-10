package com.demo.newsapp.network.entity

data class ArticleListResp(
    val data: ArticlePage,
    val errorCode: Int,
    val errorMsg: String
)