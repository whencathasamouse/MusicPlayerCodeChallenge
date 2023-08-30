package com.example.musicplayer.rooms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.musicplayer.R
import com.example.musicplayer.shared.theme.HeosTheme

@Composable
fun RoomRoute(
    modifier: Modifier = Modifier,
    viewModel: RoomViewModel = hiltViewModel()
) {
    val uiState: RoomScreenState.State by viewModel.uiStateFlow.collectAsState()
    RoomScreen(
        modifier = modifier,
        uiState = uiState
    )
}

@Composable
private fun RoomScreen(
    modifier: Modifier = Modifier,
    uiState: RoomScreenState.State
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().background(HeosTheme.color.customColor),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        uiState.rooms.forEach {
            item {
                RoomItem(
                    room = it,
                    onSelected = { room ->
                    }
                )
            }
        }
    }
}

@Composable
private fun RoomItem(
    room: RoomState,
    onSelected: (RoomState) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .defaultMinSize(minHeight = 44.dp)
            .fillMaxWidth()
            .clickable {
                onSelected(room)
            },
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = room.art,
                placeholder = painterResource(id = R.drawable.ic_room),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = room.deviceName, style = HeosTheme.typography.display1)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    when (room.playingState) {
                        PlayingState.PLAYING -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_play),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        PlayingState.PAUSED -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_pause),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        PlayingState.IDLE -> {} // do nothing
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = room.trackName, style = MaterialTheme.typography.bodySmall)
                    Spacer(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(2.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                    Text(text = room.artist, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
