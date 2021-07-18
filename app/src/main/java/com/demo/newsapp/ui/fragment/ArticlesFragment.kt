package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.newsapp.databinding.FragmentChapterBinding
import com.demo.newsapp.network.entity.PublicTab
import com.demo.newsapp.ui.adapters.ArticlesAdapter
import com.demo.newsapp.viewmodel.ArticlesViewModel

class ArticlesFragment : Fragment() {

    private var name: String = ""
    private var chapterId: Int = -1
    private lateinit var layout: FragmentChapterBinding
    private val articlesVm by activityViewModels<ArticlesViewModel>()
    private var adapter = ArticlesAdapter()

    companion object {
        fun newInstance(publicTab: PublicTab) = ArticlesFragment().apply {
            arguments = bundleOf(
                "name" to publicTab.name,
                "chapterId" to publicTab.id
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentChapterBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
        initViews()
        initVm()
        articlesVm.loadArticles(chapterId)
    }

    private fun initViews() {
        layout.recyclerview.adapter = adapter
        layout.recyclerview.layoutManager = LinearLayoutManager(context)
    }

    private fun initVm() {
        articlesVm.articles.observe(viewLifecycleOwner) { newArticles ->
            adapter.updateDatas(newArticles)
        }
    }

    private fun initArgs() {
        name = arguments?.getString("name", "") ?: ""
        chapterId = arguments?.getInt("chapterId") ?: -1
    }
}