package com.tasneem.newsapp.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Single
import org.koin.core.context.GlobalContext

@Single
actual class NewsDatabaseBuilder actual constructor() {
    actual fun getBuilder(): RoomDatabase.Builder<NewsDatabase> {
        val appContext = GlobalContext.get().get<Context>()
        val dbFile = appContext.getDatabasePath(NewsDatabase.DATABASE_NAME)
        return Room.databaseBuilder<NewsDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}