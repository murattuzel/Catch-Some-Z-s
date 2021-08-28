package com.murattuzel.catchsomezs.ui.login

import androidx.lifecycle.viewModelScope
import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseViewModel
import com.murattuzel.catchsomezs.internal.extension.isValidPassword
import com.murattuzel.catchsomezs.internal.extension.isValidUsername
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {
    val username = MutableStateFlow("")
    val password = MutableStateFlow("")
    val usernameErrorMessage = MutableStateFlow<Int?>(null)
    val passwordErrorMessage = MutableStateFlow<Int?>(null)

    private val inputValidationState: StateFlow<Boolean> = combine(
        username,
        password
    ) { username, password ->
        username.isValidUsername() && password.isValidPassword()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    private var areInputsValid: Boolean = false

    init {
        viewModelScope.launch {
            inputValidationState.collect {
                areInputsValid = it
            }
        }
    }

    val onContinue: (() -> Unit) = {
        if (areInputsValid) {
            usernameErrorMessage.value = null
            passwordErrorMessage.value = null
            navigate(
                LoginFragmentDirections.actionLoginToHome(
                    argUsername = username.value
                )
            )
        } else {
            usernameErrorMessage.value = R.string.login_username_error_message
            passwordErrorMessage.value = R.string.login_password_error_message
        }
    }
}
