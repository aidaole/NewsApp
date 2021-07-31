package com.demo.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.newsapp.R
import com.demo.newsapp.base.IFragmentCreator

class ArticleDetailFragment : Fragment(R.layout.fragment_article_detail), IFragmentCreator {

    override fun create(bundle: Bundle): Fragment {
        return ArticleDetailFragment().apply {
            arguments = bundle
        }
    }
}