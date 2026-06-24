package com.tasneem.newsapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceDto(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String
)
