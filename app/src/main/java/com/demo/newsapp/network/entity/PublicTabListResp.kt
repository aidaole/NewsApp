package com.demo.newsapp.network.entity

data class PublicTabListResp(
    val data: List<PublicTab>,
    val errorCode: Int,
    val errorMsg: String
)