package com.tasneem.newsapp.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.tasneem.newsapp.data.local.dao.NewsDao
import com.tasneem.newsapp.data.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
@ConstructedBy(NewsDatabaseConstructor::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao

    companion object {
        const val DATABASE_NAME = "news_database.db"
    }
}

@Suppress("KotlinNoActualForExpect")
expect object NewsDatabaseConstructor : RoomDatabaseConstructor<NewsDatabase> {
    override fun initialize(): NewsDatabase
}