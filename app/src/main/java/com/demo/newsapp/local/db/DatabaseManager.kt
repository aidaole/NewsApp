package com.demo.newsapp.local.db

import androidx.room.Room
import com.demo.newsapp.App
import com.demo.newsapp.local.db.dao.UserDao

object DatabaseManager {
    private val db: AppDatabase = Room.databaseBuilder(
        App.getContext(),
        AppDatabase::class.java,
        "wan.db"
    ).build()

    fun userDao(): UserDao {
        return db.userDao()
    }
}