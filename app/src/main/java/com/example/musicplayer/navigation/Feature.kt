package com.example.musicplayer.navigation

import com.example.musicplayer.R

sealed class Feature(val title: String, val icon: Int, val route: String) {
    object Rooms: Feature(route = "rooms", icon = R.drawable.ic_room, title = "Rooms")
    object NowPlaying: Feature(route = "nowplaying", icon = R.drawable.ic_now_playing, title = "Playing")
    object Setting: Feature(route = "setting", icon = R.drawable.ic_setting, title = "Setting")
}
