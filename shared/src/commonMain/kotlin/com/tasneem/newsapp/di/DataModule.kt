package com.tasneem.newsapp.di

import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasource
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasourceImpl
import com.tasneem.newsapp.data.remote.network.NewsApiClient
import org.koin.dsl.module

internal val dataModule = module {
    single {
        NewsApiClient()
    }

    single<NewsRemoteDatasource> {
        NewsRemoteDatasourceImpl(get())
    }
}

