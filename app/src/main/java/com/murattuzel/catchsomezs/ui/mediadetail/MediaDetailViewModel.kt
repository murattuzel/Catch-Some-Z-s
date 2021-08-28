package com.murattuzel.catchsomezs.ui.mediadetail

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.murattuzel.catchsomezs.base.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId

class MediaDetailViewModel @AssistedInject constructor(
    @Assisted("titleRes") private val titleRes: Int,
    @Assisted("header") private val header: String,
    @Assisted("description") private val description: String,
    @Assisted("date") private val date: Long,
) : BaseViewModel() {
    private val _mediaDetailViewState = MutableLiveData<MedialDetailViewState>()
    val mediaDetailViewState: LiveData<MedialDetailViewState> = _mediaDetailViewState

    init {
        _mediaDetailViewState.value = MedialDetailViewState(
            toolbarTitleRes = titleRes,
            header = header,
            description = description,
            date = Instant.ofEpochMilli(date)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
        )
    }

    companion object {
        fun provideFactory(
            assistedFactory: MediaDetailViewModelFactory,
            @StringRes titleRes: Int,
            header: String,
            description: String,
            date: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(
                    titleRes = titleRes,
                    header = header,
                    description = description,
                    date = date
                ) as T
            }
        }
    }
}
