package com.demo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.network.entity.PublicTab
import com.demo.newsapp.repo.NewsRepo
import com.demo.newsapp.utils.toast
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsRepo = NewsRepo()

    private val _chapters: MutableLiveData<List<PublicTab>> = MutableLiveData()
    val chapters: LiveData<List<PublicTab>>
        get() = _chapters

    fun loadChapters() {
        viewModelScope.launch {
            val result = newsRepo.getChapters()
            if (result.errorCode == 0) {
                _chapters.value = result.data
            } else {
                "请求Chapter列表信息失败".toast()
            }
        }
    }
}