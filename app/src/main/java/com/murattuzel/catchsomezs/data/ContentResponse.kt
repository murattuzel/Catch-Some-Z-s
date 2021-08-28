package com.murattuzel.catchsomezs.data

import kotlinx.serialization.Serializable

@Serializable
data class ContentResponse(
    val isBannerEnabled: Boolean,
    val meditations: List<MeditationResponse>,
    val stories: List<StoryResponse>,
)

@Serializable
data class MeditationResponse(
    val title: String,
    val subtitle: String,
    val image: ImageResponse,
    val releaseDate: Long,
    val content: String
)

@Serializable
data class StoryResponse(
    val name: String,
    val category: String,
    val image: ImageResponse,
    val date: Long,
    val text: String
)

@Serializable
data class ImageResponse(
    val small: String,
    val large: String
)
