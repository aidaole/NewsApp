package com.demo.newsapp.network

import okhttp3.ResponseBody
import retrofit2.Converter

object StringConverter : Converter<ResponseBody, String> {
    override fun convert(value: ResponseBody): String {
        return value.string()
    }
}