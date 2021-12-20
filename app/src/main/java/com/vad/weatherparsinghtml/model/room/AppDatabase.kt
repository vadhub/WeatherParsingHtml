package com.vad.weatherparsinghtml.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vad.weatherparsinghtml.model.city.CitiesDao
import com.vad.weatherparsinghtml.model.city.entities.City
import com.vad.weatherparsinghtml.utils.Convertors

@Database(
    version = 1,
    entities = [
        City::class
    ]
)
@TypeConverters(Convertors::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCities(): CitiesDao
}