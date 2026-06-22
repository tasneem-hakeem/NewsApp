package com.tasneem.newsapp.data.remote.network

expect object ApiKeyProvider {
    fun getApiKey(): String
}