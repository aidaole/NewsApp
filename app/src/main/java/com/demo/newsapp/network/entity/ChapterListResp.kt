package com.demo.newsapp.network.entity

data class ChapterListResp(
    val data: List<Chapter>,
    val errorCode: Int,
    val errorMsg: String
)