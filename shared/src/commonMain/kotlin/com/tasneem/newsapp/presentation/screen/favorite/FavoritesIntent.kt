package com.tasneem.newsapp.presentation.screen.favorite

import com.tasneem.newsapp.domain.model.Article

sealed interface FavoritesIntent {
    data class RemoveFromFavorites(val article: Article) : FavoritesIntent
}