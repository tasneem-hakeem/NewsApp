package com.tasneem.newsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform