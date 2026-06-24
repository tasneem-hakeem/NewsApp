package com.tasneem.newsapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tasneem.newsapp.data.local.database.NewsDatabase
import com.tasneem.newsapp.data.local.database.NewsDatabaseBuilder
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasource
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasourceImpl
import com.tasneem.newsapp.data.remote.network.NewsApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.Single
import org.koin.dsl.module

internal val dataModule = module {
    single {
        NewsApiClient()
    }

    single<NewsRemoteDatasource> {
        NewsRemoteDatasourceImpl(get())
    }

    @Single
    fun provideDatabase(builder: NewsDatabaseBuilder): NewsDatabase {
        return builder.getBuilder()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }


    single {
        get<NewsDatabase>().getNewsDao()
    }
}

