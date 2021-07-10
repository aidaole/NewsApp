package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.demo.newsapp.databinding.FragmentHomePageBinding
import com.demo.newsapp.network.entity.Chapter
import com.demo.newsapp.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class HomePageFragment : Fragment() {

    private lateinit var layout: FragmentHomePageBinding
    private val newsVm by activityViewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentHomePageBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initVm()
        doAfterInit()
    }

    private fun initViews() {
        layout.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        layout.viewpager.adapter = ChapterFragmentPagerAdatper(childFragmentManager)
        layout.tablayout.setupWithViewPager(layout.viewpager)
    }

    private fun initVm() {
        newsVm.chapters.observe(viewLifecycleOwner) { chapters ->
            chapters.forEach { chapter ->
                layout.tablayout.newTab().apply {
                    text = chapter.name
                }.also {
                    layout.tablayout.addTab(it)
                    (layout.viewpager.adapter as ChapterFragmentPagerAdatper).addItem(chapter)
                }
            }
            layout.viewpager.adapter?.notifyDataSetChanged()
        }
    }

    private fun doAfterInit() {
        newsVm.loadChapters()
    }

    private class ChapterFragmentPagerAdatper(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {

        private val chapters = mutableListOf<Chapter>()
        private val fragments = mutableListOf<Fragment>()

        fun addItem(chapter: Chapter) {
            chapters.add(chapter)
        }

        override fun getCount(): Int = chapters.size

        override fun getItem(position: Int): Fragment {
            if (position >= fragments.size) {
                fragments.add(ArticlesFragment.newInstance(chapters.get(position)))
            }
            return fragments.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence = chapters.get(position).name
    }
}