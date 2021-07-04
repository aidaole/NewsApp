package com.demo.newsapp.utils

import android.util.Log

const val DEFAULT_TAG = "NewsApp"

fun String.logd(tag: String = DEFAULT_TAG) {
    Log.d(tag, "logd: $this")
}

fun String.logi(tag: String = DEFAULT_TAG) {
    Log.i(tag, this)
}

fun String.loge(tag: String = DEFAULT_TAG) {
    Log.e(tag, this)
}
