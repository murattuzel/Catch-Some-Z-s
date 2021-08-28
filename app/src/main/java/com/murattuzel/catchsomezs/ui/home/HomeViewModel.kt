package com.murattuzel.catchsomezs.ui.home

import androidx.lifecycle.SavedStateHandle
import com.murattuzel.catchsomezs.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private val username = savedStateHandle.get<String>("arg_username").orEmpty()
}
