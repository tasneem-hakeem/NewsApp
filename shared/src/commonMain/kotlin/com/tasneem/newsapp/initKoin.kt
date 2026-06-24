package com.tasneem.newsapp

import com.tasneem.newsapp.di.dataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)

        modules(
            modules = dataModule
        )
    }
}