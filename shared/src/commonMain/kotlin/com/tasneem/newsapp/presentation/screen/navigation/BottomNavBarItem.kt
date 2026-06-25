package com.tasneem.newsapp.presentation.screen.navigation

import newsapp.shared.generated.resources.Res
import newsapp.shared.generated.resources.ic_heart_outlined
import newsapp.shared.generated.resources.ic_home
import org.jetbrains.compose.resources.DrawableResource

enum class BottomBarItems(
    val icon: DrawableResource,
    val label: String,
    val route: Route
) {
    NEWS(
        icon = Res.drawable.ic_home,
        label = "Home",
        route = Route.News
    ),
    FAVORITES(
        icon = Res.drawable.ic_heart_outlined,
        label = "Favorites",
        route = Route.Favorite
    ),
}