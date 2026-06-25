package com.tasneem.newsapp.domain.model

data class Article(
    val id: String,
    val title: String,
    val description: String,
    val sourceUrl: String,
    val imageUrl: String,
    val publishedAt: String,
    val content: String,
    val source: String,
)