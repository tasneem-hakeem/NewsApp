package com.tasneem.newsapp.data.remote.network

import platform.Foundation.NSBundle

actual object ApiKeyProvider {
    actual fun getApiKey(): String {
        val bundle = NSBundle.mainBundle
        return bundle.objectForInfoDictionaryKey("API_KEY") as? String
            ?: throw IllegalStateException("API_KEY not found in Info.plist")
    }
}