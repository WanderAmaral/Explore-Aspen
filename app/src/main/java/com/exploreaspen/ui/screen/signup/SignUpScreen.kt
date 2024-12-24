package com.exploreaspen.ui.screen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.components.header.ExploreAspenHeader
import com.exploreaspen.ui.screen.signup.components.input.SignUpInput
import com.exploreaspen.ui.states.SignUpUiState
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Typography

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, uiState: SignUpUiState,onSignUpClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(state = rememberScrollState()),
    ) {
        ExploreAspenHeader(text = "New Account")
        Column(modifier = modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {

            Text(text = "Full name", style = Typography.headlineMedium)
            SignUpInput(placeholder = "Jhon Doe", value = "", onValueChange = {})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Password", style = Typography.headlineMedium)
            SignUpInput(
                placeholder = "*********",
                value = "",
                onValueChange = {},
                isPassword = true
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Email", style = Typography.headlineMedium)
            SignUpInput(placeholder = "example@example.com", value = "", onValueChange = {})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Mobile Number", style = Typography.headlineMedium)
            SignUpInput(placeholder = "(11) 11111-1111", value = "", onValueChange = {})
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Date Of Birth", style = Typography.headlineMedium)
            SignUpInput(placeholder = "DD/MM/YYY", value = "", onValueChange = {}, isDate = true)
            Spacer(modifier = Modifier.height(10.dp))



            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "By continuing, you agree to \n" +
                            " Terms of Use and Privacy Policy.", style = Typography.bodySmall, textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(10.dp))

                    ExploreAspenButton(
                        modifier = Modifier.width(250.dp),
                        text = "Log In",
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "or sign up with", style = Typography.bodySmall)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ExploreAspenButton(onClick = {}, iconRes = Icons.Filled.Mail)
                        ExploreAspenButton(onClick = {}, iconRes = Icons.Filled.Fingerprint)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(text = "Don’t have an account?")
                        TextButton(onClick = { }, contentPadding = PaddingValues(0.dp)) {
                            Text(
                                text = "Sign Up",
                                style = Typography.bodyMedium.copy(color = BlueTitle)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(onSignUpClick = {}, uiState = SignUpUiState())
}

