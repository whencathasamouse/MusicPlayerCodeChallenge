package com.example.musicplayer.nowplaying

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NowPlayingRoute(
    modifier: Modifier = Modifier
) {
    NowPlayingScreen(modifier = modifier)
}

@Composable
private fun NowPlayingScreen(
    modifier: Modifier = Modifier
) {
    Text(text = "Now Playing")
}
