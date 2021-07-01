package com.demo.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.repo.NewsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(
    newsRepo: NewsRepo
) : ViewModel() {

    fun loadBreakingNews() = viewModelScope.launch {

    }
}