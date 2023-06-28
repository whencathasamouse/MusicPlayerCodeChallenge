package com.example.musicplayer.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.shared.data.repository.DeviceRepo
import com.example.musicplayer.shared.data.repository.TrackRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val deviceRepo: DeviceRepo,
    private val trackRepo: TrackRepo
) : ViewModel() {

    private var _uiStateFlow = MutableStateFlow(RoomScreenState.State())
    val uiStateFlow: StateFlow<RoomScreenState.State> = _uiStateFlow

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    private suspend fun loadData() {
        val devices = deviceRepo.getAllDevices()
        val tracks = trackRepo.getAllTracks()

        _uiStateFlow.value = RoomScreenState.State(
            rooms = devices.map { device ->
                val track = tracks.find { it.deviceId == device.id }
                RoomState(
                    deviceId = device.id,
                    deviceName = device.name,
                    art = track?.artSmall ?: "",
                    artist = track?.artist ?: "",
                    trackName = track?.name ?: "",
                    playingState = if (track == null) PlayingState.IDLE else PlayingState.PLAYING
                )
            }
        )
    }

    private fun selectRoom(deviceId: Int) {
        // TODO
    }

    fun onUiAction(action: RoomScreenState.Action) {
        when (action) {
            is RoomScreenState.Action.SelectRoom -> viewModelScope.launch {
                selectRoom(action.deviceId)
            }
        }
    }
}
