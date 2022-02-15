package com.vad.weatherparsinghtml.model.room.weather

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather

@Dao
interface WeatherDao {

    @Query("SELECT * FROM Weather ORDER BY id_weather ASC")
    fun getAllWeathers(): LiveData<List<Weather>>

    @Update
    suspend fun updateWeather(weather: Weather)

    @Insert
    suspend fun addWeather(weather: Weather)

    @Query("DELETE FROM Weather WHERE id_weather=:id")
    suspend fun deleteWeather(id: Long)
}