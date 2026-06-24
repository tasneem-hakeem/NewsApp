package com.tasneem.newsapp.data.local.dao
import androidx.room.Dao
import androidx.room.Query
import com.tasneem.newsapp.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM articles")
    fun getAll(): Flow<List<ArticleEntity>>
}