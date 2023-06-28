package com.example.musicplayer.shared.data.repository

import com.example.musicplayer.shared.data.model.Track
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface TrackRepo {
    suspend fun getAllTracks(): List<Track>
}

class TrackRepoImpl @Inject constructor() : TrackRepo {
    override suspend fun getAllTracks(): List<Track> = withContext(Dispatchers.IO) {
        // TODO: replace with network resource
        return@withContext listOf(
            Track(
                deviceId = 1,
                artSmall = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Appetite+For+Destruction+-+small.jpg",
                artLarge = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Appetite+For+Destruction+-+large.jpg",
                name = "Welcome To The Jungle",
                artist = "Guns N' Roses"
            ),
            Track(
                deviceId = 2,
                artSmall = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Brothers+In+Arms+-+small.jpg",
                artLarge = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Brothers+In+Arms+-+large.jpg",
                name = "Down To The Waterline",
                artist = "Dire Straights"
            ),
            Track(
                deviceId = 3,
                artSmall = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Elephant+-+small.jpg",
                artLarge = "https://skyegloup-eula.s3.amazonaws.com/heos_app/code_test/Elephant+-+large.jpg",
                name = "The Less I Know The Better",
                artist = "Tame Impala"
            )
        )
    }
}
