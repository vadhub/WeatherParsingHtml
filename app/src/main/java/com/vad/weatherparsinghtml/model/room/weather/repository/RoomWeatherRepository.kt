package com.vad.weatherparsinghtml.model.room.weather.repository

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import com.vad.weatherparsinghtml.model.room.weather.WeatherDao
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather

class RoomWeatherRepository(private val dao: WeatherDao) {
    val getAllWeather: LiveData<List<Weather>> = dao.getAllWeathers()

    suspend fun addWeather(weather: Weather) {
        try {
            dao.addWeather(weather)
        } catch (e: SQLiteConstraintException) {
            e.printStackTrace()
        }
    }

    suspend fun update(weather: Weather) {
        dao.updateWeather(weather)
    }

    suspend fun delete(id: Long) {
        dao.deleteWeather(id)
    }


}