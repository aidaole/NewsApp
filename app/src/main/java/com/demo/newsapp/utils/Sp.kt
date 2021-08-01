package com.demo.newsapp.utils

import android.content.Context
import androidx.core.content.edit
import com.demo.newsapp.App

object Sp {

    private const val SP_NAME_COMMON = "sp_name_common"
    private val commonSp by lazy {
        App.getContext().getSharedPreferences(SP_NAME_COMMON, Context.MODE_PRIVATE)
    }

    fun getInt(key: String): Int {
        return commonSp.getInt(key, 0)
    }

    fun saveInt(key: String, value: Int) {
        commonSp.edit {
            putInt(key, value)
            apply()
        }
    }
}