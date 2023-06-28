package com.example.musicplayer.shared.data.di

import com.example.musicplayer.shared.data.repository.DeviceRepo
import com.example.musicplayer.shared.data.repository.DeviceRepoImpl
import com.example.musicplayer.shared.data.repository.TrackRepo
import com.example.musicplayer.shared.data.repository.TrackRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsDeviceRepository(
        deviceRepo: DeviceRepoImpl
    ): DeviceRepo

    @Binds
    fun bindsTrackRepository(
        trackRepo: TrackRepoImpl
    ): TrackRepo
}
