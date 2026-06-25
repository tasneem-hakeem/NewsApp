package com.tasneem.newsapp.presentation.screen.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tasneem.newsapp.presentation.screen.theme.AppColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    items: List<BottomBarItems> = BottomBarItems.entries.toList(),
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    NavigationBar(
        modifier = modifier,
        containerColor = AppColors.surface,
    ) {
        items.forEach { destination ->
            val isSelected = currentDestination?.hasRoute(destination.route::class) == true

            val labelColor by animateColorAsState(
                targetValue = if (isSelected) AppColors.body else AppColors.hint,
            )
            val iconColor by animateColorAsState(
                targetValue = if (isSelected) AppColors.primary else AppColors.hint,
            )

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                label = {
                    Text(
                        text = destination.label,
                        color = labelColor,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.icon),
                        contentDescription = destination.label,
                        tint = iconColor,
                    )
                },
            )
        }
    }
}