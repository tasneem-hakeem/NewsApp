package com.tasneem.newsapp.data.remote.datasource

import com.tasneem.newsapp.data.remote.dto.ArticleResponse

interface NewsRemoteDatasource {
    suspend fun getTopHeadlines(
        country: String = "us"
    ): ArticleResponse
}