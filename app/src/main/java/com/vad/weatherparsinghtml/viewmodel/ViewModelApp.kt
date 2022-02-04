package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.model.room.city.repository.RoomCitiesRepository
import com.vad.weatherparsinghtml.model.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelApp(application: Application) : AndroidViewModel(application) {

    private val repository: RoomCitiesRepository
    val readAllData: LiveData<List<City>>

    init {
        val citiesDao = AppDatabase.getDatabase(application).getCities()
        repository = RoomCitiesRepository(citiesDao)
        readAllData = repository.getAllCities
    }

    fun addCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(city)
        }
    }
}