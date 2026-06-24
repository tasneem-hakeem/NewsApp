package com.tasneem.newsapp.data.remote.mapper

import com.tasneem.newsapp.data.remote.dto.ArticleDto
import com.tasneem.newsapp.data.remote.dto.ArticleResponse
import com.tasneem.newsapp.domain.model.Article

fun ArticleDto.toDomain() = Article(
    title = title ?: "",
    description = description ?: "",
    sourceUrl = sourceUrl ?: "",
    imageUrl = imageUrl ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: "",
    source = source?.name ?: "",
)

fun ArticleResponse.toDomain(): List<Article> {
    return articles.map { it.toDomain() }
}