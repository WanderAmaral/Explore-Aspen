package com.exploreaspen.ui.states

data class SignUpUiState(
    val name: String = "",
    val password: String = "",
    val email: String = "",
    val mobileNumber: String = "",
    val dateOfBirth: String = "",
    val error: String? = null
)