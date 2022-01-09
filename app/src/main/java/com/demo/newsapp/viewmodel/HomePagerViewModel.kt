package com.demo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.newsapp.network.RetrofitManager
import com.demo.newsapp.network.entity.Article
import com.demo.newsapp.network.entity.Banner
import com.demo.newsapp.utils.logd
import kotlinx.coroutines.launch

class HomePagerViewModel : ViewModel() {
    private val newsApi by lazy { RetrofitManager.newsApi() }

    private val _banners = MutableLiveData<List<Banner>>()
    val banners: LiveData<List<Banner>>
        get() = _banners

    private var _page = 1

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    fun loadDatas() {
        "开始加载首页数据".logd()
        viewModelScope.launch {
            val resp = newsApi.getHomeBanners()
            _banners.value = resp.data
            "加载banner内容完成".logd()

            val articleResp = newsApi.getHomePageArticles(_page)
            _articles.value = articleResp.data.datas
            _page = articleResp.data.curPage
            "加载article内容完成".logd()
        }
    }
}
