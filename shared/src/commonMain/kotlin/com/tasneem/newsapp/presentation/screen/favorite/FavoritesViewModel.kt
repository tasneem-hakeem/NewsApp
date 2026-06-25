package com.tasneem.newsapp.presentation.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.usecase.GetFavoriteArticlesUseCase
import com.tasneem.newsapp.domain.usecase.RemoveFromFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    init {
        observeFavorites()
    }

    fun handleIntent(intent: FavoritesIntent) {
        when (intent) {
            is FavoritesIntent.RemoveFromFavorites -> removeFavorite(intent.article)
        }
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavoriteArticlesUseCase().collect { favorites ->
                _uiState.update { it.copy(favoriteArticles = favorites) }
            }
        }
    }

    private fun removeFavorite(article: Article) {
        viewModelScope.launch {
            removeFromFavoritesUseCase(article)
        }
    }
}