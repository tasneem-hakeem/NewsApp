package com.tasneem.newsapp.data.local.datasource

import com.tasneem.newsapp.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface NewsLocalDatasource {

    fun getFavoriteArticles(): Flow<List<ArticleEntity>>

    suspend fun saveFavoriteArticle(article: ArticleEntity)

    suspend fun removeFavoriteArticle(article: ArticleEntity)
}