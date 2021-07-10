package com.demo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.network.entity.Article
import com.demo.newsapp.network.entity.ArticleListResp
import com.demo.newsapp.repo.NewsRepo
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {

    private val newsRepo = NewsRepo()
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    fun loadArticles(chapterId: Int, page: Int = 1) {
        viewModelScope.launch {
            val resp = newsRepo.getChapterArticles(chapterId, page)
            _articles.value = resp.data.datas
        }
    }
}