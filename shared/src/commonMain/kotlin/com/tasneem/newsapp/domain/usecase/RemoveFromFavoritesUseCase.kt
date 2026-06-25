package com.tasneem.newsapp.domain.usecase

import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.repository.NewsRepository

class RemoveFromFavoritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        return repository.removeFromFavorites(article)
    }
}