package com.tasneem.newsapp.domain.usecase

import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteArticlesUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return repository.getFavoriteArticles()
    }
}