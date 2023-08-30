package com.example.musicplayer.shared.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.musicplayer.BuildConfig

@Composable
fun MyTheme(
    flavor: String = BuildConfig.FLAVOR,
    content: @Composable () -> Unit
) {
    val typography = when (BuildConfig.FLAVOR) {
        "other" -> MyTypography(
            display1 = TextStyle(
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
        )
        else -> MyTypography()
    }
    CompositionLocalProvider(
        LocalColor provides MyColor,
        LocalTypography provides typography
    ) {
        content()
    }
}

object HeosTheme {
    val color: MyColor
        @Composable
        get() = LocalColor.current
    val typography: MyTypography
        @Composable
        get() = LocalTypography.current

//    val typography: TypographySystem
//        @Composable
//        get() = LocalTypographySystem.current

//    val spacingTokens
}
