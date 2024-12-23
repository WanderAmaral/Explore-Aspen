package com.exploreaspen.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.exploreaspen.R


val leagueSpartanFontFamily = FontFamily(
    Font(R.font.league_spartan, FontWeight.Normal),
    Font(R.font.league_spartan_medium, FontWeight.Medium),
    Font(R.font.league_spartan_bold, FontWeight.Bold),
    Font(R.font.league_spartan_semibold, FontWeight.SemiBold)
)

private const val activatePreview = true

val Typography = Typography(
    // "Title XI"
    headlineLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    // "Title Lg"
    headlineMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    // "Title Md"
    headlineSmall = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    // "Text Sm"
    titleLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    // "Text Md"
    bodyLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    // "Text Sm"
    bodyMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    // "Text Xs"
    bodySmall = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    // "Action"
    labelLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    // "Subtitle"
    labelMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else leagueSpartanFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)