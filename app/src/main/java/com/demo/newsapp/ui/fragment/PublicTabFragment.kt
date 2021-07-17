package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.demo.newsapp.databinding.FragmentPublicTabBinding
import com.demo.newsapp.network.entity.PublicTab
import com.demo.newsapp.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class PublicTabFragment : Fragment() {

    private lateinit var layout: FragmentPublicTabBinding
    private val newsVm by activityViewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentPublicTabBinding.inflate(inflater, container, false)
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
            override fun onTabSelected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        layout.viewpager.adapter = PublicTabPagerAdapter(childFragmentManager)
        layout.tablayout.setupWithViewPager(layout.viewpager)
    }

    private fun initVm() {
        newsVm.chapters.observe(viewLifecycleOwner) { chapters ->
            chapters.forEach { chapter ->
                layout.tablayout.newTab().apply {
                    text = chapter.name
                }.also {
                    layout.tablayout.addTab(it)
                    (layout.viewpager.adapter as PublicTabPagerAdapter).addItem(chapter)
                }
            }
            layout.viewpager.adapter?.notifyDataSetChanged()
        }
    }

    private fun doAfterInit() {
        newsVm.loadChapters()
    }

    private class PublicTabPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {

        private val chapters = mutableListOf<PublicTab>()
        private val fragments = mutableListOf<Fragment>()

        fun addItem(publicTab: PublicTab) {
            chapters.add(publicTab)
        }

        override fun getCount(): Int = chapters.size

        override fun getItem(position: Int): Fragment {
            if (position >= fragments.size) {
                fragments.add(ArticlesFragment.newInstance(chapters[position]))
            }
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence = chapters[position].name
    }
}