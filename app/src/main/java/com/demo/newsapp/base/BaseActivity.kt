package com.demo.newsapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(val layoutId: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initViews()
        initVm()
        doAfterInit()
    }

    abstract fun initViews()
    abstract fun initVm()
    abstract fun doAfterInit()
}