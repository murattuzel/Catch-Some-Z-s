package com.murattuzel.catchsomezs.domain.model

import com.murattuzel.catchsomezs.base.ListAdapterItem

data class ContentUiModel(
    val isBannerEnabled: Boolean,
    val meditations: List<MeditationUiModel>,
    val stories: List<StoryUiModel>,
)

data class MeditationUiModel(
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val date: Long,
    val content: String
) : ListAdapterItem {
    override val id = hashCode()
}

data class StoryUiModel(
    val name: String,
    val category: String,
    val imageUrl: String,
    val date: Long,
    val text: String
) : ListAdapterItem {
    override val id = hashCode()
}
