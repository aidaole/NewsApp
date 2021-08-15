package com.demo.newsapp.utils

import androidx.fragment.app.Fragment

fun Fragment.getString(resId: Int): String {
    return context?.getString(resId) ?: ""
}