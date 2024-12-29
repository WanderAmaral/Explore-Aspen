package com.exploreaspen.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Gray100
import com.exploreaspen.ui.theme.Typography
import np.com.bimalkafle.firebaseauthdemoapp.AuthState
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel


@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val authState = authViewModel.authState.observeAsState()
    val userName = remember { mutableStateOf("") }

    LaunchedEffect(authState.value) {

        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("signIn")
            else -> Unit
        }

        authViewModel.fetchUserName { name -> userName.value = name }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 40.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .verticalScroll(state = rememberScrollState())
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),

                        iconRes = Icons.Filled.Notifications,

                        onClick = {}
                    )
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),
                        iconRes = Icons.Filled.Settings,
                        onClick = {}
                    )
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),
                        iconRes = Icons.Filled.Search,
                        onClick = {},

                        )

                }
                Row(

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = modifier.fillMaxHeight().padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.End,

                    ) {
                        Text(text = "Hi, Welcome", style = Typography.bodyMedium, color = BlueTitle)
                        Text(text = "${userName.value}", style = Typography.labelMedium)
                    }
                    ExploreAspenButton(iconRes = Icons.Filled.Logout,
                        modifier = modifier
                            .background(
                                Color.Transparent,
                                RoundedCornerShape(60.dp)
                            )
                            .size(40.dp)
                            .padding(3.dp),

                        onClick = {
                            authViewModel.signout()
                        })
                }

            }
        }
    }
}

@Preview
@Composable
private fun HomePageScreenPreview() {
    val fakeAuthViewModel = AuthViewModel()

    val navController = rememberNavController()


    HomePageScreen(
        navController = navController,
        authViewModel = fakeAuthViewModel
    )
}