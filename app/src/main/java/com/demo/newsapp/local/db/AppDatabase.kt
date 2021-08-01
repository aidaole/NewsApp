package com.demo.newsapp.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.newsapp.local.db.dao.UserDao
import com.demo.newsapp.local.db.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}