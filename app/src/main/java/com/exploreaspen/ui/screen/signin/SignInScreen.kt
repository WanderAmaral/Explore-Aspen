package com.exploreaspen.ui.screen.signin

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.navigation.NavController
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.components.header.ExploreAspenHeader
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Typography
import com.exploreaspen.ui.theme.WhiteExtraLight
import com.exploreaspen.ui.theme.leagueSpartanFontFamily
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel

@Composable
fun SignInScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {


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
                    keyboardType = KeyboardType.Text
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
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
                        text = "*********",
                        style = TextStyle(BlueTitle, fontSize = 18.sp)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
            TextButton(
                onClick = { },
                modifier = modifier.align(Alignment.End),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Forget Password",
                    style = Typography.bodyMedium.copy(color = BlueTitle),
                    modifier = modifier.padding(top = 0.dp)

                )
            }
            Spacer(modifier = modifier.height(20.dp))
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
                    ExploreAspenButton(
                        modifier = Modifier.width(250.dp),
                        text = "Log In",
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "or sign up with", style = Typography.bodyMedium)
                    Spacer(modifier = Modifier.height(20.dp))
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
                        TextButton(onClick = { navController.navigate("signUp") }, contentPadding = PaddingValues(0.dp)) {
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
private fun SignInScreenPreview() {
    //SignInScreen()
}