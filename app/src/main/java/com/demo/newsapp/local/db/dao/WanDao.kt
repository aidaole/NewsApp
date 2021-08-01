package com.demo.newsapp.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.demo.newsapp.network.entity.UserInfo

@Dao
abstract class WanDao {

    @Insert
    abstract fun saveUser(userInfo: UserInfo)
}