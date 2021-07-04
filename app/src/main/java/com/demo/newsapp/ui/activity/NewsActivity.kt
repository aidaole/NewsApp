package com.demo.newsapp.ui.activity

import androidx.activity.viewModels
import com.demo.newsapp.R
import com.demo.newsapp.base.BaseActivity
import com.demo.newsapp.utils.logd
import com.demo.newsapp.viewmodel.NewsViewModel

class NewsActivity : BaseActivity(R.layout.activity_news) {

    private val newsVm by viewModels<NewsViewModel>()

    override fun initViews() {
    }

    override fun initVm() {

    }

    override fun doAfterInit() {

    }
}