package com.vad.weatherparsinghtml.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vad.weatherparsinghtml.model.city.entities.City

@Database(
    version = 1,
    entities = [
        City::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
}