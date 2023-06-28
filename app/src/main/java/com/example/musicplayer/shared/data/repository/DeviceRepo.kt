package com.example.musicplayer.shared.data.repository

import com.example.musicplayer.shared.data.model.Device
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface DeviceRepo {
    suspend fun getAllDevices(): List<Device>
}

class DeviceRepoImpl @Inject constructor() : DeviceRepo {
    override suspend fun getAllDevices(): List<Device> = withContext(Dispatchers.IO) {
        // TODO: replace with network resource
        return@withContext listOf(
            Device(id = 1, name = "Living Room"),
            Device(id = 2, name = "Kitchen"),
            Device(id = 3, name = "Bedroom")
        )
    }
}
