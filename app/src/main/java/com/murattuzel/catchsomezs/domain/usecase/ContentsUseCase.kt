package com.murattuzel.catchsomezs.domain.usecase

import com.murattuzel.catchsomezs.data.ContentRemoteDataSource
import com.murattuzel.catchsomezs.data.ContentResponse
import com.murattuzel.catchsomezs.domain.mapper.MeditationUiModelMapper
import com.murattuzel.catchsomezs.domain.mapper.StoryUiModelMapper
import com.murattuzel.catchsomezs.domain.model.ContentUiModel
import javax.inject.Inject

class ContentsUseCase @Inject constructor(
    private val dataSource: ContentRemoteDataSource,
    private val meditationMapper: MeditationUiModelMapper,
    private val storyUiModelMapper: StoryUiModelMapper
) : UseCase<ContentResponse, ContentUiModel, Unit>() {

    override suspend fun buildUseCase(params: Unit): ContentResponse =
        dataSource.fetchContents()

    override fun map(dataSourceType: ContentResponse): ContentUiModel = with(dataSourceType) {
        ContentUiModel(
            isBannerEnabled = isBannerEnabled,
            meditations = meditations.map { meditationMapper.mapToUiModel(it) },
            stories = stories.map { storyUiModelMapper.mapToUiModel(it) }
        )
    }
}
