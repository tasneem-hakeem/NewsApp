package com.tasneem.newsapp.data.remote.network
import com.tasneem.newsapp.BuildKonfig

actual object ApiKeyProvider {
    actual fun getApiKey(): String = BuildKonfig.NEWS_API_KEY
    actual fun getBaseUrl(): String = BuildKonfig.NEWS_API_BASE_URL
}