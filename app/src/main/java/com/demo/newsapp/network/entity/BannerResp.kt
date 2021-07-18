package com.demo.newsapp.network.entity

data class BannerResp(
    val data: List<Banner>,
    val errorCode: Int,
    val errorMsg: String
)
