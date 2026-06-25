package com.tasneem.newsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val title: String,
    @ColumnInfo val description: String,
    @ColumnInfo val sourceUrl: String,
    @ColumnInfo val imageUrl: String,
    @ColumnInfo val publishedAt: String,
    @ColumnInfo val content: String,
    @ColumnInfo val source: String,
)
