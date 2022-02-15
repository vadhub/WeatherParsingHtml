package com.vad.weatherparsinghtml.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vad.weatherparsinghtml.model.room.city.CitiesDao
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.model.room.weather.WeatherDao
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather
import com.vad.weatherparsinghtml.utils.Convertors

@Database(
    version = 3,
    entities = [
        City::class,
        Weather::class
    ]
)
@TypeConverters(Convertors::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCities(): CitiesDao
    abstract fun getWeathersDao(): WeatherDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val  tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}