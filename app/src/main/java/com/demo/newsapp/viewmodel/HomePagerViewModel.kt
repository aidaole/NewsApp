package com.demo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.network.RetrofitManager
import com.demo.newsapp.network.entity.Banner
import com.demo.newsapp.utils.logd
import kotlinx.coroutines.launch

class HomePagerViewModel : ViewModel() {
    private val newsApi by lazy { RetrofitManager.newsApi() }

    private val _banners = MutableLiveData<List<Banner>>()
    val banners: LiveData<List<Banner>>
        get() = _banners

    fun loadDatas() {
        "home page load data start".logd()
        viewModelScope.launch {
            val resp = newsApi.getHomeBanners()
            _banners.value = resp.data
        }
    }
}
