package com.tasneem.newsapp.presentation.screen.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tasneem.newsapp.presentation.components.ArticleCard
import com.tasneem.newsapp.presentation.screen.theme.AppColors
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(color = AppColors.primary)
        }

        state.errorMessage?.let { error ->
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }

        if (!state.isLoading && state.errorMessage == null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Breaking News",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
                items(state.articles, key = { it.id }) { article ->
                    val isFavorite = state.favoriteArticleIds.contains(article.id)
                    ArticleCard(
                        article = article,
                        isFavorite = isFavorite,
                        onFavoriteClick = { viewModel.handleIntent(NewsIntent.ToggleFavorite(article)) }
                    )
                }
            }
        }
    }
}