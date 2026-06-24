package com.tasneem.newsapp.data.local.database

import androidx.room.RoomDatabase
import org.koin.core.annotation.Single

@Single
expect class NewsDatabaseBuilder() {
    fun getBuilder(): RoomDatabase.Builder<NewsDatabase>
}