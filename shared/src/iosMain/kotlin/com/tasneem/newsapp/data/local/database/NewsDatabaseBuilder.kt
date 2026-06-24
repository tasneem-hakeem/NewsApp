package com.tasneem.newsapp.data.local.database

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Single
import platform.Foundation.NSHomeDirectory

@Single
actual class NewsDatabaseBuilder actual constructor() {
    actual fun getBuilder(): RoomDatabase.Builder<NewsDatabase> {
        val dbFile = NSHomeDirectory() + "/${NewsDatabase.DATABASE_NAME}"
        return Room.databaseBuilder<NewsDatabase>(
            name = dbFile,
        )
    }
}