package com.tasneem.newsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.tasneem.newsapp.presentation.screen.navigation.BottomNavBar
import com.tasneem.newsapp.presentation.screen.navigation.NavGraph

@Composable
@Preview
fun App() {
    MaterialTheme {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavBar(navController = navController)
            }
        ) { paddingValues ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}