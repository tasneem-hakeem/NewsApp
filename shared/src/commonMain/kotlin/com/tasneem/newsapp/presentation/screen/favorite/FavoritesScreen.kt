package com.tasneem.newsapp.presentation.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tasneem.newsapp.presentation.components.ArticleCard
import com.tasneem.newsapp.presentation.components.DeleteConfirmationDialog
import com.tasneem.newsapp.presentation.screen.theme.AppColors
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (state.favoriteArticles.isEmpty()) {
            Text(
                text = "No favorite articles found.",
                style = MaterialTheme.typography.bodyLarge,
                color = AppColors.hint
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.favoriteArticles, key = { it.id }) { article ->
                    ArticleCard(
                        article = article,
                        isFavorite = true,
                        onFavoriteClick = {
                            viewModel.handleIntent(FavoritesIntent.ShowDeleteConfirmation(article))
                        }
                    )
                }
            }
        }
    }

    state.articlePendingDeletion?.let { article ->
        DeleteConfirmationDialog(
            onConfirm = {
                viewModel.handleIntent(FavoritesIntent.RemoveFromFavorites(article))
            },
            onDismiss = {
                viewModel.handleIntent(FavoritesIntent.DismissDeleteConfirmation)
            },
            title = "Delete this item?",
            subtitle = "Are you sure you want to delete this element?\nThis action is final."
        )
    }
}