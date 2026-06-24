package com.tasneem.newsapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasource
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasourceImpl
import kotlinx.coroutines.launch
import newsapp.shared.generated.resources.Res
import newsapp.shared.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.getKoin
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {

    val datasource: NewsRemoteDatasource = koinInject()
    val scope = rememberCoroutineScope()

    Button(
        onClick = {
            println("BUTTON CLICKED")

            scope.launch {
                try {
                    println("STARTING REQUEST")

                    val response = datasource.getTopHeadlines("us")

                    println("SUCCESS")
                    println(response)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    ) {
        Text("Load News")
    }
}