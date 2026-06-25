package com.tasneem.newsapp.presentation.screen.news

import com.tasneem.newsapp.domain.model.Article

data class NewsUiState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val favoriteArticleIds: Set<String> = emptySet(),
    val errorMessage: String? = null
)

