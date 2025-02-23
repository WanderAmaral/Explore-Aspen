package com.exploreaspen.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val GradientBlue = Brush.linearGradient(
    colors = listOf(
        Color(0xFF33E4DB),
        Color(0xFF00BBD3)
    )
)

val GradientBlueTransparent = Brush.linearGradient(
    colors = listOf(
        Color(0x33E4DBFF), // Cor #33E4DB com alpha 0x33 (20% de opacidade)
        Color(0x0000BBD3)  // Cor #00BBD3 com alpha 0x00 (totalmente transparente)
    )
)

val TransparentGreen = Color(0x33FF5722)
val BlueTitle = Color(0xFF33E4DB)
val BlueParagrapph = Color(0xFF00BBD3)
val WhiteExtraLight = Color(0xFFE9F6FE)
val White = Color(0xFFFFFFFF)


val GreenLight = Color(0xFF3B9B62)
val GreenBase = Color(0xFF257F49)
val GreenDark = Color(0xFF052914)
val GreenExtraLight = Color(0xFFE9F6FE)

val RedLight = Color(0xFFFDEDED)
val RedBase = Color(0xFFF94144)

val Gray100 = Color(0xFFFCFDFE)
val Gray200 = Color(0xFFE1EBF4)
val Gray300 = Color(0xFFC4D0DB)
val Gray400 = Color(0xFF73808C)
val Gray500 = Color(0xFF45525F)
val Gray600 = Color(0xFF1A1F24)