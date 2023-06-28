package com.example.musicplayer.rooms

object RoomScreenState {
    data class State(
        val rooms: List<RoomState> = emptyList()
    )

    sealed class Action {
        data class SelectRoom(val deviceId: Int) : Action()
    }
}

data class RoomState(
    val deviceId: Int = 0,
    val deviceName: String = "",
    val art: String = "",
    val artist: String = "",
    val trackName: String = "",
    val playingState: PlayingState = PlayingState.IDLE
)

enum class PlayingState {
    PLAYING,
    PAUSED,
    IDLE
}
