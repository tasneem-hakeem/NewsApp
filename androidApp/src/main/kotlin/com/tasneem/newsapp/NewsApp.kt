package com.tasneem.newsapp

import android.app.Application
import org.koin.android.ext.koin.androidContext

class NewsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidContext(this@NewsApp)
        }
    }
}