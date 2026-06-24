package com.tasneem.newsapp.data.remote.network

import platform.Foundation.NSBundle

actual object ApiKeyProvider {
    actual fun getApiKey(): String {
        val bundle = NSBundle.mainBundle
        return bundle.objectForInfoDictionaryKey("NEWS_API_KEY") as? String
            ?: throw IllegalStateException("NEWS_API_KEY not found in Info.plist")
    }

    actual fun getBaseUrl(): String {
        val bundle = NSBundle.mainBundle
        return bundle.objectForInfoDictionaryKey("NEWS_API_BASE_URL") as? String
            ?: throw IllegalStateException("NEWS_API_BASE_URL not found in Info.plist")
    }
}