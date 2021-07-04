package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.demo.newsapp.databinding.FragmentChapterBinding
import com.demo.newsapp.network.entity.Chapter

class ChapterFragment : Fragment() {

    private var name: String = ""
    private var chapterId: Int = -1
    private lateinit var layout: FragmentChapterBinding

    companion object {
        fun newInstance(chapter: Chapter) = ChapterFragment().apply {
            arguments = bundleOf(
                "name" to chapter.name,
                "chapterId" to chapter.id
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
        layout.chapterName.text = name
    }

    private fun initArgs() {
        name = arguments?.getString("name", "") ?: ""
        chapterId = arguments?.getInt("chapterId") ?: -1
    }
}