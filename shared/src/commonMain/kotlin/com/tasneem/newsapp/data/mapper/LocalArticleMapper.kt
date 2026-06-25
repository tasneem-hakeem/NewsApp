package com.tasneem.newsapp.data.mapper

import com.tasneem.newsapp.data.local.entity.ArticleEntity
import com.tasneem.newsapp.data.remote.dto.ArticleDto
import com.tasneem.newsapp.data.remote.dto.ArticleResponse
import com.tasneem.newsapp.domain.model.Article
import kotlinx.serialization.json.JsonNull.content
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun ArticleEntity.toDomain() = Article(
    id = id,
    title = title,
    description = description,
    sourceUrl = sourceUrl,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    content = content,
    source = source,
)

@OptIn(ExperimentalUuidApi::class)
fun Article.toEntity() = ArticleEntity(
    id = id,
    title = title,
    description = description,
    sourceUrl = sourceUrl,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    content = content,
    source = source,
)