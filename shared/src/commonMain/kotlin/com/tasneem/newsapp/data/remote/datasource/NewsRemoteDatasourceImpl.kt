package com.tasneem.newsapp.data.remote.datasource

import com.tasneem.newsapp.data.remote.dto.ArticleResponse
import com.tasneem.newsapp.data.remote.network.NewsApiClient
import com.tasneem.newsapp.data.remote.network.safeApiCall
import io.ktor.client.request.parameter

class NewsRemoteDatasourceImpl(
    private val client: NewsApiClient
) : NewsRemoteDatasource {
    override suspend fun getTopHeadlines(country: String): ArticleResponse =
        safeApiCall {
            client.get("top-headlines") {
                parameter("country", country)
            }
        }
}