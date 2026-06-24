package com.tasneem.newsapp.data.remote.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NewsApiClient {
    private val client: HttpClient by lazy { buildHttpClient() }

    // public HTTP methods
    internal suspend fun get(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse = client.get(path, block)

    internal suspend fun post(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse = client.post(path, block)

    internal suspend fun put(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse = client.put(path, block)

    internal suspend fun patch(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse = client.patch(path, block)

    internal suspend fun delete(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse = client.delete(path, block)

    // build client
    private fun buildHttpClient(): HttpClient {
        val apiKey = ApiKeyProvider.getApiKey()
        val baseUrl = ApiKeyProvider.getBaseUrl()

        return HttpClient {
            defaultRequest {
                url(baseUrl)
                contentType(ContentType.Application.Json)
                parameters {
                    append("apiKey", apiKey)
                }
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = false
                    prettyPrint = false
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15_000
                connectTimeoutMillis = 15_000
                socketTimeoutMillis = 15_000
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
}