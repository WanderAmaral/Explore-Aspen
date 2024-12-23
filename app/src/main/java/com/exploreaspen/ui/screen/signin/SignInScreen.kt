package com.exploreaspen.ui.screen.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exploreaspen.ui.components.header.ExploreAspenHeader
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Typography
import com.exploreaspen.ui.theme.WhiteExtraLight
import com.exploreaspen.ui.theme.leagueSpartanFontFamily

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(state = rememberScrollState()),

        ) {
        ExploreAspenHeader(text = "Log In")

        Column(modifier = modifier.padding(horizontal = 30.dp, vertical = 40.dp)) {
            Spacer(modifier = Modifier.width(48.dp))

            Text(text = "Welcome", style = Typography.headlineLarge, color = BlueTitle)

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit, sed do " +
                        "eiusmod tempor incididunt ut labore et " +
                        "dolore magna aliqua. ",
                textAlign = TextAlign.Left,
                style = Typography.bodySmall
            )

            Spacer(modifier = Modifier.height(50.dp))


            Text(text = "Email or Mobile Number", style = Typography.headlineMedium)

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = modifier
                    .padding(horizontal = 1.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(WhiteExtraLight, RoundedCornerShape(17.dp)),
                shape = RoundedCornerShape(17.dp),
                placeholder = {
                    Text(
                        text = "example@example.com",
                        style = TextStyle(BlueTitle, fontSize = 18.sp)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text // Define o tipo de teclado como texto.
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent, // Remove a borda quando focado
                    unfocusedBorderColor = Color.Transparent // Remove a borda quando não focado
                )
            )


            Text(text = "Password", style = Typography.headlineMedium)

            OutlinedTextField(
                value = "",
                onValueChange = {},

                modifier = modifier
                    .padding(horizontal = 1.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .background(WhiteExtraLight, RoundedCornerShape(17.dp)),
                shape = RoundedCornerShape(17.dp),
                placeholder = {
                    Text(
                        text = "",
                        style = TextStyle(BlueTitle, fontSize = 18.sp)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password // Define o tipo do teclado como senha
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent, // Remove a borda quando focado
                    unfocusedBorderColor = Color.Transparent // Remove a borda quando não focado
                )
            )
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}