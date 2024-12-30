package com.exploreaspen.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.exploreaspen.R
import com.exploreaspen.ui.theme.GradientBlueTheme
import kotlinx.coroutines.delay
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    LaunchedEffect(key1 = Unit) {
        delay(2_000)
        navController.navigate("signIn")
    }


    Box(
        modifier = modifier
            .background(GradientBlueTheme)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_white),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold)) {
                        append("Health")
                    }
                    append("Track")
                },
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    //SplashScreen()
}