package com.tasneem.newsapp.domain.repository

import com.tasneem.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getTopHeadlines(): List<Article>

    fun getFavoriteArticles(): Flow<List<Article>>

    suspend fun addToFavorites(article: Article)

    suspend fun removeFromFavorites(article: Article)
}
