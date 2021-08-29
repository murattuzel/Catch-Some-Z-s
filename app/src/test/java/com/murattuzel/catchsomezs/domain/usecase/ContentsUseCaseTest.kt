package com.murattuzel.catchsomezs.domain.usecase

import com.murattuzel.catchsomezs.data.ContentRemoteDataSource
import com.murattuzel.catchsomezs.data.ContentResponse
import com.murattuzel.catchsomezs.data.MeditationResponse
import com.murattuzel.catchsomezs.data.StoryResponse
import com.murattuzel.catchsomezs.domain.mapper.MeditationUiModelMapper
import com.murattuzel.catchsomezs.domain.mapper.StoryUiModelMapper
import com.murattuzel.catchsomezs.domain.model.ContentUiModel
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel
import com.murattuzel.catchsomezs.domain.model.StoryUiModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class ContentsUseCaseTest {

    @MockK
    lateinit var dataSource: ContentRemoteDataSource

    @MockK
    lateinit var meditationUiModelMapper: MeditationUiModelMapper

    @MockK
    lateinit var storyUiModelMapper: StoryUiModelMapper

    @InjectMockKs
    lateinit var contentsUseCase: ContentsUseCase

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `fetch content list successfully when requested`() {
        val isBannerEnabled = false
        val meditationResponse = mockk<MeditationResponse>()
        val storyResponse = mockk<StoryResponse>()
        val contentResponse = ContentResponse(
            isBannerEnabled = isBannerEnabled,
            meditations = listOf(meditationResponse),
            stories = listOf(storyResponse)
        )
        val meditationUiModel = mockk<MeditationUiModel>()
        val storyUiModel = mockk<StoryUiModel>()
        val contentUiModel = ContentUiModel(
            isBannerEnabled = isBannerEnabled,
            meditations = listOf(meditationUiModel),
            stories = listOf(storyUiModel)
        )

        every {
            meditationUiModelMapper.mapToUiModel(meditationResponse)
        } returns meditationUiModel

        every {
            storyUiModelMapper.mapToUiModel(storyResponse)
        } returns storyUiModel

        coEvery {
            dataSource.fetchContents()
        } returns contentResponse

        val result = runBlocking {
            contentsUseCase(Unit)
        }

        assertTrue(result.isSuccess)
        result.onSuccess {
            assertEquals(it, contentUiModel)
        }
    }

    @Test
    fun `verify fetching content list failure when requested`() {
        val exception = IOException()

        coEvery {
            dataSource.fetchContents()
        } throws exception

        val result = runBlocking {
            contentsUseCase(Unit)
        }

        assertTrue(result.isFailure)
        result.onFailure {
            assertEquals(it, exception)
        }
    }
}
