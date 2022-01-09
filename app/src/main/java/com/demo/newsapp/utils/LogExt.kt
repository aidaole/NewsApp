package com.demo.newsapp.utils

import android.util.Log

const val DEFAULT_TAG = "NewsApp"

fun String.logd(tag: String = DEFAULT_TAG): String {
    Log.d(tag, "logd: $this")
    return this
}

fun String.logi(tag: String = DEFAULT_TAG): String {
    Log.i(tag, this)
    return this
}

fun String.loge(tag: String = DEFAULT_TAG): String {
    Log.e(tag, this)
    return this
}


