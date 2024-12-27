package com.exploreaspen.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exploreaspen.ui.components.header.ExploreAspenHeader
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel

@Composable
fun HomePageScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 40.dp)
    ) {
        ExploreAspenHeader(text = "Hello")
    }
}