package com.exploreaspen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exploreaspen.ui.screen.home.HomePageScreen
import com.exploreaspen.ui.screen.signin.SignInScreen
import com.exploreaspen.ui.screen.signup.SignUpScreen
import com.exploreaspen.ui.screen.splash.SplashScreen
import com.exploreaspen.ui.states.SignUpUiState
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {

    val navController = rememberNavController() // Crie o navController aqui

    NavHost(navController = navController, startDestination = "splash", builder = {
        composable("splash") {
            SplashScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("signIn") {
            SignInScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("signUp") {
            SignUpScreen(
                navController = navController,
                authViewModel = authViewModel,
                onSignUpClick = {},
                uiState = SignUpUiState()
            )
        }
        composable("homepage") {
            HomePageScreen(
               navController = navController,
                authViewModel = authViewModel,
            )
        }
    })
}