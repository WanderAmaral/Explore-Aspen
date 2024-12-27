package com.exploreaspen.ui.viewmodels

import com.exploreaspen.ui.states.SignUpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {

    var uiState = mutableStateOf(SignUpUiState())
        private set

    fun setName(newName: String) {
        uiState.value = uiState.value.copy(name = newName)
    }

    fun setPassword(newPassword: String) {
        uiState.value = uiState.value.copy(password = newPassword)
    }

    fun setEmail(newEmail: String) {
        uiState.value = uiState.value.copy(email = newEmail)
    }

    fun setMobileNumber(newMobileNumber: String) {
        uiState.value = uiState.value.copy(mobileNumber = newMobileNumber)
    }

    fun setDateOfBirth(newDateOfBirth: String) {
        uiState.value = uiState.value.copy(dateOfBirth = newDateOfBirth)
    }

}

