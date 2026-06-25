package com.tasneem.newsapp.domain.usecase// shared/src/commonMain/kotlin/com/tasneem/newsapp/domain/usecase/GetTopHeadlinesUseCase.kt

import com.tasneem.newsapp.domain.model.Article
import com.tasneem.newsapp.domain.repository.NewsRepository

class GetTopHeadlinesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<Article> {
        return repository.getTopHeadlines()
    }
}