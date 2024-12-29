package com.exploreaspen.ui.screen.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.components.header.ExploreAspenHeader
import com.exploreaspen.ui.screen.signup.components.input.SignUpInput
import com.exploreaspen.ui.states.SignUpUiState
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Typography
import com.exploreaspen.ui.viewmodels.SignUpViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import np.com.bimalkafle.firebaseauthdemoapp.AuthState
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onSignUpClick: () -> Unit,
    viewModel: SignUpViewModel = viewModel(),
    navController: NavController,
    authViewModel: AuthViewModel
) {

    val uiState by viewModel.uiState

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 40.dp)
    ) {

        ExploreAspenHeader(
            text = "New Account",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter), navController = navController, buttonBack = true
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .verticalScroll(state = rememberScrollState())
        ) {

            Text(text = "Name", style = Typography.headlineMedium)
            SignUpInput(
                placeholder = "Jhon Doe",
                value = uiState.name,
                onValueChange = { viewModel.setName(it) })
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Email", style = Typography.headlineMedium)
            SignUpInput(
                placeholder = "example@example.com",
                value = uiState.email,
                onValueChange = { viewModel.setEmail(it) })
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Password", style = Typography.headlineMedium)
            SignUpInput(
                placeholder = "*********",
                value = uiState.password,
                onValueChange = { viewModel.setPassword(it) },
                isPassword = true
            )
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "By continuing, you agree to \n" +
                            " Terms of Use and Privacy Policy.",
                    style = Typography.bodySmall,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExploreAspenButton(
                    modifier = Modifier.width(250.dp),
                    text = "Create Account",
                    onClick = { authViewModel.signup(uiState.email, uiState.password, uiState.name) }
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
            }
        }
    }


}

@Preview
@Composable
private fun SignUpScreenPreview() {
    var navController = rememberNavController()

    SignUpScreen(
        onSignUpClick = {},
        uiState = SignUpUiState(),
        authViewModel = AuthViewModel(),
        navController = navController
    )
}

