package com.demo.newsapp.utils

import android.content.Context
import android.widget.Toast
import com.demo.newsapp.App

fun String.toast(duration: Int = Toast.LENGTH_SHORT, context: Context = App.getContext()): String {
    Toast.makeText(context, this, duration).show()
    return this
}