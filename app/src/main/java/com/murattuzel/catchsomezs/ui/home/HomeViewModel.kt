package com.murattuzel.catchsomezs.ui.home

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseViewModel
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel
import com.murattuzel.catchsomezs.domain.model.StoryUiModel
import com.murattuzel.catchsomezs.domain.usecase.ContentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val contentsUseCase: ContentsUseCase
) : BaseViewModel() {
    @VisibleForTesting
    var username = savedStateHandle.get<String>("arg_username").orEmpty()
    val meditationData = MutableLiveData<List<MeditationUiModel>>()
    val storyData = MutableLiveData<List<StoryUiModel>>()
    val bannerVisibility = MutableLiveData<Boolean>()

    init {
        fetchContentData()
    }

    val onMeditationClick: ((MeditationUiModel) -> Unit) = {
        navigate(
            HomeFragmentDirections.actionHomeToDetail(
                argToolbarTitle = R.string.meditation_detail_title,
                argHeader = it.title,
                argDescription = it.subtitle,
                argDate = it.date
            )
        )
    }

    val onStoryClick: ((StoryUiModel) -> Unit) = {
        navigate(
            HomeFragmentDirections.actionHomeToDetail(
                argToolbarTitle = R.string.story_detail_title,
                argHeader = it.name,
                argDescription = it.text,
                argDate = it.date
            )
        )
    }

    private fun fetchContentData() = viewModelScope.launch {
        contentsUseCase(Unit)
            .onSuccess { contentUiModel ->
                meditationData.value = contentUiModel.meditations
                storyData.value = contentUiModel.stories
                bannerVisibility.value = contentUiModel.isBannerEnabled
            }
            .onFailure { Timber.d("fetchContentData onFailure: $it") }
    }
}
