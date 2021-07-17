package com.demo.newsapp.repo

import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.PublicTabListResp

interface INewsRepo {

    suspend fun getChapters(): PublicTabListResp
    suspend fun getChapterArticles(chapterId: Int, page: Int): ArticleListResp
}