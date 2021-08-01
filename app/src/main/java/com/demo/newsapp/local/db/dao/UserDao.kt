package com.demo.newsapp.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.demo.newsapp.local.db.entity.User

@Dao
abstract class UserDao {

    @Query("SELECT * FROM user WHERE id=(:userId)")
    abstract fun getUser(userId: Int): User?

    @Insert(onConflict = REPLACE)
    abstract fun saveUser(user: User): Long
}