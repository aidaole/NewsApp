package com.demo.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.newsapp.R

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {

    companion object {
        fun create(bundle: Bundle): SearchNewsFragment {
            return SearchNewsFragment().apply {
                arguments = bundle
            }
        }
    }
}