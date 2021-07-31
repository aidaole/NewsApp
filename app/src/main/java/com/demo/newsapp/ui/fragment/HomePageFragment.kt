package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.newsapp.GlideApp
import com.demo.newsapp.databinding.FragmentBannerBinding
import com.demo.newsapp.databinding.FragmentHomePageBinding
import com.demo.newsapp.network.entity.Banner
import com.demo.newsapp.ui.adapters.ArticlesAdapter
import com.demo.newsapp.utils.toast
import com.demo.newsapp.viewmodel.HomePagerViewModel

class HomePageFragment : Fragment() {

    companion object {
        @JvmStatic
        fun create(bundle: Bundle): HomePageFragment {
            return HomePageFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var layout: FragmentHomePageBinding
    private val homePageVm: HomePagerViewModel by viewModels()
    private val bannerAdapter: BannerFragmentStateAdapter
            by lazy { BannerFragmentStateAdapter(this, emptyList()) }
    private val articlesAdapter: ArticlesAdapter
            by lazy { ArticlesAdapter() }

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
        init()
    }

    private fun init() {
        layout.bannerViewpager.adapter = bannerAdapter
        homePageVm.banners.observe(viewLifecycleOwner) { banners ->
            banners?.let {
                bannerAdapter.updateDatas(it)
            }
        }
        layout.recyclerview.adapter = articlesAdapter
        layout.recyclerview.layoutManager = LinearLayoutManager(context)
        homePageVm.articles.observe(viewLifecycleOwner) { articles ->
            articles?.let {
                articlesAdapter.updateDatas(it)
            }
        }
        afterInit()
    }

    private fun afterInit() {
        homePageVm.loadDatas()
    }
}

class BannerFragmentStateAdapter(fragment: Fragment, var banners: List<Banner>) :
    FragmentStateAdapter(fragment) {

    fun updateDatas(newBanners: List<Banner>) {
        banners = newBanners
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = banners.size

    override fun createFragment(position: Int): Fragment {
        return BannerFragment.create(banners[position])
    }
}

class BannerFragment : Fragment() {
    private lateinit var layout: FragmentBannerBinding
    private val desc: String? by lazy { arguments?.getString("desc") }
    private val imagePath: String? by lazy { arguments?.getString("imagePath") }
    private val url: String? by lazy { arguments?.getString("url") }

    companion object {
        fun create(banner: Banner): BannerFragment = BannerFragment().apply {
            arguments = bundleOf(
                "desc" to banner.desc,
                "imagePath" to banner.imagePath,
                "url" to banner.url
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = FragmentBannerBinding.inflate(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(this)
            .load(imagePath)
            .into(layout.bannerImage)
        layout.bannerDesc.text = desc
        layout.bannerImage.setOnClickListener {
            "click ${url}".toast()
        }
    }
}