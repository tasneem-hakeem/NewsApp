package com.tasneem.newsapp.presentation.screen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tasneem.newsapp.presentation.screen.articles.NewsScreen
import com.tasneem.newsapp.presentation.screen.favorite.FavoritesScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.News,
        modifier = modifier
    ) {
        composable<Route.News> {
            NewsScreen()
        }

        composable<Route.Favorite> {
            FavoritesScreen()
        }
    }
}