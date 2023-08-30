package com.example.musicplayer.shared.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Can also be data class, so it can be overridden with other values if needed
// Unfortunatelly, these text appearance have to be duplicated in xml to support xml usage

data class MyTypography(
    var display1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val LocalTypography = staticCompositionLocalOf { MyTypography() }
