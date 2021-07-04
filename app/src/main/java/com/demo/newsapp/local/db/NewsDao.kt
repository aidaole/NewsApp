package com.demo.newsapp.local.db

abstract class NewsDao {
    abstract fun saveNews(): Int
}