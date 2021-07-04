package com.demo.newsapp.network.entity

data class Resp<T>(
    val `data`: List<T>,
    val errorCode: Int,
    val errorMsg: String
)