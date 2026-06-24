package com.tasneem.newsapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    @SerialName("author") val author: String? = null,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String? = null,
    @SerialName("url") val sourceUrl: String,
    @SerialName("urlToImage") val imageUrl: String? = null,
    @SerialName("publishedAt") val publishedAt: String,
    @SerialName("content") val content: String? = null,
    @SerialName("source") val source: SourceDto? = null,
)

