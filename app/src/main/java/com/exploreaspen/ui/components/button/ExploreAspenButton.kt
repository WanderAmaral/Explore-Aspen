package com.exploreaspen.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exploreaspen.ui.theme.GradientBlue
import com.exploreaspen.ui.theme.GreenDark
import com.exploreaspen.ui.theme.Typography

@Composable
fun ExploreAspenButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    textColor: Color = Color.White,
    iconRes: ImageVector? = null,
    onClick: () -> Unit,
    colorButton: Color = Color.White
) {
    Box(
        modifier = modifier.background(GradientBlue, RoundedCornerShape(60.dp))    ) {
        Button(
            modifier = modifier.heightIn(min = 56.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(30.dp),
            contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                iconRes?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "Ícone do botão",
                        modifier = modifier.size(40.dp),
                        tint = colorButton
                    )
                }

                text?.let {
                    Text(
                        text = text.uppercase(),
                        color = textColor,
                        style = Typography.labelLarge
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ExploreAspenButtonPreview() {
//    ExploreAspenButton(onClick = {}, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
private fun ExploreAspenButtonWithTextPreview() {
    ExploreAspenButton(
        onClick = {},
        text = "Botão",
        modifier = Modifier.fillMaxWidth().background(Color.Transparent)
    )
}

@Preview
@Composable
private fun ExploreAspenButtonWithIconPreview() {
    ExploreAspenButton(onClick = {}, iconRes = Icons.Filled.Home)

}