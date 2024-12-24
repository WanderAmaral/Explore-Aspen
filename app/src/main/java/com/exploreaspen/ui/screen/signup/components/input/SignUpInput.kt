package com.exploreaspen.ui.screen.signup.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.WhiteExtraLight

@Composable
fun SignUpInput(modifier: Modifier = Modifier,
                placeholder: String,
                value: String,
                onValueChange: (String) -> Unit,
                keyboardType: KeyboardType = KeyboardType.Text,
                isPassword: Boolean = false,
                isDate: Boolean? = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(horizontal = 1.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(WhiteExtraLight, RoundedCornerShape(17.dp)),
        shape = RoundedCornerShape(17.dp),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(BlueTitle, fontSize = 18.sp)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Preview
@Composable
private fun SignUpInputPreview() {
    SignUpInput(placeholder = "example@example.com", onValueChange = {}, value = "")
}