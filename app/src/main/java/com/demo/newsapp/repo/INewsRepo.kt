package com.demo.newsapp.repo

import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.network.entity.ChapterListResp

interface INewsRepo {

    suspend fun getChapters(): ChapterListResp
    suspend fun getChapterArticles(chapterId: Int, page: Int): ArticleListResp
}