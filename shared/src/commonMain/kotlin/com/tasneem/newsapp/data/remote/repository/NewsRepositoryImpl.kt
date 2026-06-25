package com.tasneem.newsapp.data.remote.repository

import com.tasneem.newsapp.data.local.datasource.NewsLocalDatasource
import com.tasneem.newsapp.data.mapper.toDomain
import com.tasneem.newsapp.data.mapper.toEntity
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasource
import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepositoryImpl(
    private val remote: NewsRemoteDatasource,
    private val local: NewsLocalDatasource
) : NewsRepository {
    override suspend fun getTopHeadlines(): List<Article> {
        return remote.getTopHeadlines().toDomain()
    }

    override fun getFavoriteArticles(): Flow<List<Article>> {
        return local.getFavoriteArticles().map { it.map { article -> article.toDomain() } }
    }

    override suspend fun addToFavorites(article: Article) {
        local.saveFavoriteArticle(article.toEntity())
    }

    override suspend fun removeFromFavorites(article: Article) {
        local.removeFavoriteArticle(article.toEntity())
    }
}