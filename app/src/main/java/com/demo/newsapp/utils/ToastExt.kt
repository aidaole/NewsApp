package com.demo.newsapp.utils

import android.widget.Toast
import com.demo.newsapp.App

fun String.toast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.getContext(), this, duration).show()
}