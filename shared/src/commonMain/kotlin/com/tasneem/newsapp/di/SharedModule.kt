package com.tasneem.newsapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tasneem.newsapp.data.local.database.NewsDatabase
import com.tasneem.newsapp.data.local.database.NewsDatabaseBuilder
import com.tasneem.newsapp.data.local.datasource.NewsLocalDatasource
import com.tasneem.newsapp.data.local.datasource.NewsLocalDatasourceImpl
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasource
import com.tasneem.newsapp.data.remote.datasource.NewsRemoteDatasourceImpl
import com.tasneem.newsapp.data.remote.network.NewsApiClient
import com.tasneem.newsapp.data.remote.repository.NewsRepositoryImpl
import com.tasneem.newsapp.domain.repository.NewsRepository
import com.tasneem.newsapp.domain.usecase.AddToFavoritesUseCase
import com.tasneem.newsapp.domain.usecase.GetFavoriteArticlesUseCase
import com.tasneem.newsapp.domain.usecase.GetTopHeadlinesUseCase
import com.tasneem.newsapp.domain.usecase.RemoveFromFavoritesUseCase
import com.tasneem.newsapp.presentation.screen.favorite.FavoritesViewModel
import com.tasneem.newsapp.presentation.screen.news.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

internal val sharedModule = module {

    // remote
    single { NewsApiClient() }
    single<NewsRemoteDatasource> { NewsRemoteDatasourceImpl(get()) }

    single { NewsDatabaseBuilder() }

    single {
        get<NewsDatabaseBuilder>().getBuilder()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    single { get<NewsDatabase>().getNewsDao() }
    single<NewsLocalDatasource> { NewsLocalDatasourceImpl(get()) }

    // repository
    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }

    // use case
    single { GetTopHeadlinesUseCase(get()) }
    single { GetFavoriteArticlesUseCase(get()) }
    single { AddToFavoritesUseCase(get()) }
    single { RemoveFromFavoritesUseCase(get()) }

    // view model
    factory { NewsViewModel(get(), get(), get(), get()) }
    factory { FavoritesViewModel(get(), get()) }
}

