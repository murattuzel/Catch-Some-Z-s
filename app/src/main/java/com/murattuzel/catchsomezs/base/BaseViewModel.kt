package com.murattuzel.catchsomezs.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.murattuzel.catchsomezs.internal.util.Event
import com.murattuzel.catchsomezs.internal.util.NavigationCommand

abstract class BaseViewModel : ViewModel() {
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(directions))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }
}
