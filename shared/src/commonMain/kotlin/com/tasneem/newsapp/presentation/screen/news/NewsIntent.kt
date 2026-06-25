package com.tasneem.newsapp.presentation.screen.news

import com.tasneem.newsapp.domain.model.Article

sealed interface NewsIntent {
    data object LoadArticles : NewsIntent
    data class ToggleFavorite(val article: Article) : NewsIntent
}