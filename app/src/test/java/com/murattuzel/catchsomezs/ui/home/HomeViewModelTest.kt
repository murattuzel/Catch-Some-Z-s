package com.murattuzel.catchsomezs.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.murattuzel.catchsomezs.CoroutinesTestRule
import com.murattuzel.catchsomezs.domain.model.ContentUiModel
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel
import com.murattuzel.catchsomezs.domain.model.StoryUiModel
import com.murattuzel.catchsomezs.domain.usecase.ContentsUseCase
import com.murattuzel.catchsomezs.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var contentsUseCase: ContentsUseCase

    @MockK
    lateinit var savedStateHandle: SavedStateHandle

    private val viewModel by lazy {
        HomeViewModel(
            contentsUseCase = contentsUseCase,
            savedStateHandle = savedStateHandle
        )
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        every {
            savedStateHandle.get<String>("arg_username")
        } returns "username"

        coEvery {
            contentsUseCase(Unit)
        } returns Result.success(mockk(relaxed = true))
    }

    @Test
    fun `update content data when contents received`() {
        val meditationUiModel = mockk<MeditationUiModel>()
        val storyUiModel = mockk<StoryUiModel>()
        val isBannerEnabled = true
        val contentUiModel = ContentUiModel(
            isBannerEnabled = isBannerEnabled,
            meditations = listOf(meditationUiModel),
            stories = listOf(storyUiModel)
        )

        coEvery {
            contentsUseCase(Unit)
        } returns Result.success(contentUiModel)

        val meditationData = viewModel.meditationData.getOrAwaitValue()
        val storyData = viewModel.storyData.getOrAwaitValue()
        val bannerVisibility = viewModel.bannerVisibility.getOrAwaitValue()

        assertEquals(meditationData, listOf(meditationUiModel))
        assertEquals(storyData, listOf(storyUiModel))
        assertEquals(bannerVisibility, isBannerEnabled)
    }

    @Test
    fun `verify navigation when meditation item clicked`() {
        viewModel.onMeditationClick.invoke(mockk(relaxed = true))

        val navigation = viewModel.navigation.getOrAwaitValue().getContentIfNotHandled()
        assertNotNull(navigation)
    }

    @Test
    fun `verify navigation when story item clicked`() {
        viewModel.onStoryClick.invoke(mockk(relaxed = true))

        val navigation = viewModel.navigation.getOrAwaitValue().getContentIfNotHandled()
        assertNotNull(navigation)
    }
}
