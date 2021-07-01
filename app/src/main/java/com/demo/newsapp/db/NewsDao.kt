package com.demo.newsapp.db

abstract class NewsDao {
    abstract fun saveNews(): Int
}