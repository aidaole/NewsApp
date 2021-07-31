package com.demo.newsapp.base

import android.os.Bundle
import androidx.fragment.app.Fragment

interface IFragmentCreator {

    fun create(bundle: Bundle): Fragment
}