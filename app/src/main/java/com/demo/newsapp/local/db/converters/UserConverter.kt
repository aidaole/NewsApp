package com.demo.newsapp.local.db.converters

import com.demo.newsapp.local.db.entity.User
import com.demo.newsapp.network.entity.UserInfo

class UserConverter {

    fun userInfoToUser(userInfo: UserInfo) = User(
        userInfo.id,
        userInfo.admin,
        userInfo.nickname,
        userInfo.email,
        userInfo.icon,
        userInfo.password,
        userInfo.publicName,
        userInfo.token,
        userInfo.type,
        userInfo.username
    )
}