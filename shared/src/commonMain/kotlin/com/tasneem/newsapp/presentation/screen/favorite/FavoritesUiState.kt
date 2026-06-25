package com.tasneem.newsapp.presentation.screen.favorite

import com.tasneem.newsapp.domain.model.Article

data class FavoritesUiState(
    val favoriteArticles: List<Article> = emptyList(),
    val articlePendingDeletion: Article? = null
)

