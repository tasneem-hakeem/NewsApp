package com.tasneem.newsapp.presentation.screen.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object News : Route

    @Serializable
    data object Favorite : Route
}