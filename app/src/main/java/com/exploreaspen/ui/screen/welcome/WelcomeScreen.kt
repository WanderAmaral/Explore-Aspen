package com.exploreaspen.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exploreaspen.R
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Typography
import com.exploreaspen.ui.theme.WhiteExtraLight

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize().padding(horizontal = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_blue),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)) {
                        append("Health")
                    }
                    append("Track")
                },
                fontSize = 30.sp,
                color = BlueTitle,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(80.dp))
            Text(
                style = Typography.bodySmall,
                textAlign = TextAlign.Center,
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            )
            Spacer(modifier = modifier.height(50.dp))
            ExploreAspenButton(text = "Log In", modifier = modifier.width(250.dp), onClick = {})
            Spacer(modifier = modifier.height(7.dp))
            ExploreAspenButton(text = "Sign Up", modifier = modifier
                .width(250.dp)
                .background(
                    WhiteExtraLight,  RoundedCornerShape (30.dp)
                ), textColor = BlueTitle, onClick = {})
        }
    }

}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}