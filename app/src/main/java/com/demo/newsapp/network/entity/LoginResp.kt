package com.demo.newsapp.network.entity

data class LoginResp(
    var data: UserInfo?,
    var errorCode: Int,
    var errorMsg: String
)