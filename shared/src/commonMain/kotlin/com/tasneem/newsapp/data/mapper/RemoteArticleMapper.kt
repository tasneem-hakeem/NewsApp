package com.tasneem.newsapp.data.mapper

import com.tasneem.newsapp.data.remote.dto.ArticleDto
import com.tasneem.newsapp.data.remote.dto.ArticleResponse
import com.tasneem.newsapp.domain.model.Article
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun ArticleDto.toDomain() = Article(
    id = Uuid.random().toString(),
    title = title,
    description = description ?: "",
    sourceUrl = sourceUrl,
    imageUrl = imageUrl ?: "",
    publishedAt = publishedAt,
    content = content ?: "",
    source = source?.name ?: "",
)

fun ArticleResponse.toDomain(): List<Article> {
    return articles.map { it.toDomain() }
}