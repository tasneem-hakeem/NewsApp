package com.tasneem.newsapp.presentation.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.usecase.AddToFavoritesUseCase
import com.tasneem.newsapp.domain.usecase.GetFavoriteArticlesUseCase
import com.tasneem.newsapp.domain.usecase.GetTopHeadlinesUseCase
import com.tasneem.newsapp.domain.usecase.RemoveFromFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    init {
        handleIntent(NewsIntent.LoadArticles)
        observeFavorites()
    }

    fun handleIntent(intent: NewsIntent) {
        when (intent) {
            is NewsIntent.LoadArticles -> loadArticles()
            is NewsIntent.ToggleFavorite -> toggleFavorite(intent.article)
        }
    }

    private fun loadArticles() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val articles = getTopHeadlinesUseCase()
                _uiState.update { it.copy(isLoading = false, articles = articles) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = e.message ?: "Unknown error") }
            }
        }
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavoriteArticlesUseCase().collect { favoriteArticles ->
                val favIds = favoriteArticles.map { it.id }.toSet()
                _uiState.update { it.copy(favoriteArticleIds = favIds) }
            }
        }
    }

    private fun toggleFavorite(article: Article) {
        viewModelScope.launch {
            val isFav = _uiState.value.favoriteArticleIds.contains(article.id)
            if (isFav) {
                removeFromFavoritesUseCase(article)
            } else {
                addToFavoritesUseCase(article)
            }
        }
    }
}