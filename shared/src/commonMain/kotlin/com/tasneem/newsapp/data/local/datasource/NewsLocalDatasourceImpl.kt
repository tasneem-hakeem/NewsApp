package com.tasneem.newsapp.data.local.datasource

import com.tasneem.newsapp.data.local.dao.NewsDao
import com.tasneem.newsapp.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

class NewsLocalDatasourceImpl(
    private val dao: NewsDao
) : NewsLocalDatasource {
    override fun getFavoriteArticles(): Flow<List<ArticleEntity>> {
        return dao.getAll()
    }

    override suspend fun saveFavoriteArticle(article: ArticleEntity) {
        dao.insert(article)
    }

    override suspend fun removeFavoriteArticle(article: ArticleEntity) {
        dao.delete(article)
    }
}