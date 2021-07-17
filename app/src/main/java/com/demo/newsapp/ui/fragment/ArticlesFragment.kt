package com.demo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.newsapp.databinding.ArticleItemViewBinding
import com.demo.newsapp.databinding.FragmentChapterBinding
import com.demo.newsapp.network.entity.Article
import com.demo.newsapp.network.entity.PublicTab
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
            val diff = ArticlesDiffCallback(adapter.getDatas(), newArticles)
            val result = DiffUtil.calculateDiff(diff)
            adapter.setDatas(newArticles)
            result.dispatchUpdatesTo(adapter)
        }
    }

    private fun initArgs() {
        name = arguments?.getString("name", "") ?: ""
        chapterId = arguments?.getInt("chapterId") ?: -1
    }
}

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private lateinit var layout: ArticleItemViewBinding
    private var articles = listOf<Article>()

    fun setDatas(articleList: List<Article>) {
        articles = articleList
    }

    fun getDatas(): List<Article> = articles

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        layout = ArticleItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articles.size

    class ArticleViewHolder(var binding: ArticleItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.title.text = article.title
            binding.desc.text = article.desc
        }
    }
}


class ArticlesDiffCallback(val oldList: List<Article>, val newList: List<Article>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = oldList[newItemPosition]
        return oldItem.id == newItem.id
    }
}