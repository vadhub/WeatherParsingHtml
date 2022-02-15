package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vad.weatherparsinghtml.model.room.AppDatabase
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather
import com.vad.weatherparsinghtml.model.room.weather.repository.RoomWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelWeathers(private val application: Application): ViewModel() {
    private val repository: RoomWeatherRepository
    val readAllData: LiveData<List<Weather>>

    init {
        val dao = AppDatabase.getDatabase(application).getWeathersDao()

        repository = RoomWeatherRepository(dao)
        readAllData = repository.getAllWeather
    }

    fun addWeather(weather: Weather) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWeather(weather)
        }
    }
}