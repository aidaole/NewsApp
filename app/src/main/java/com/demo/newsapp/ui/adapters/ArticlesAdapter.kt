package com.demo.newsapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.demo.newsapp.databinding.ArticleItemViewBinding
import com.demo.newsapp.network.entity.Article
import com.demo.newsapp.utils.toGone
import com.demo.newsapp.utils.toVisible
import java.text.SimpleDateFormat
import java.util.*

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private lateinit var layout: ArticleItemViewBinding
    private var articles = listOf<Article>()

    fun updateDatas(newArticles: List<Article>) {
        val diff = ArticlesDiffCallback(articles, newArticles)
        val result = DiffUtil.calculateDiff(diff)
        articles = newArticles
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        layout = ArticleItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articles.size

    @SuppressLint("SimpleDateFormat")
    class ArticleViewHolder(var binding: ArticleItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val publishDateFormat by lazy { SimpleDateFormat("yyyy:MM:dd") }

        fun bind(article: Article) {
            binding.title.text = article.title
            binding.publishDate.text = publishDateFormat.format(Date(article.publishTime))
            binding.author.text = article.author
            if (article.tags.isNotEmpty()) {
                binding.tag.text = article.tags[article.tags.size - 1].name
                binding.tag.toVisible()
                (binding.title.layoutParams as MarginLayoutParams).leftMargin = 20
            } else {
                binding.tag.toGone()
            }
        }
    }
}

class ArticlesDiffCallback(private val oldList: List<Article>, private val newList: List<Article>) :
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
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }
}