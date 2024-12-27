package com.exploreaspen.ui.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.theme.GradientBlue
import com.exploreaspen.ui.theme.GradientBlueTransparent
import com.exploreaspen.ui.theme.Typography

@Composable
fun ExploreAspenHeader(modifier: Modifier = Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(GradientBlue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ExploreAspenButton(
            iconRes = Icons.Filled.ChevronLeft,
            modifier = Modifier.background(Color.Transparent, RoundedCornerShape(60.dp)),
            onClick = {}
        )
        Text(
            text = text,
            style = Typography.headlineLarge,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(48.dp))
    }
}

@Preview
@Composable
private fun ExploreAspenHeaderPreview() {
    ExploreAspenHeader(text = "Log In")
}