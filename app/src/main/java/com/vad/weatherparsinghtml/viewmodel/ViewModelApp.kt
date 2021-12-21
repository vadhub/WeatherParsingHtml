package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vad.weatherparsinghtml.model.city.entities.City
import com.vad.weatherparsinghtml.model.city.repository.RoomCitiesRepository
import com.vad.weatherparsinghtml.model.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelApp(application: Application) : AndroidViewModel(application) {

    private val getCities: LiveData<List<City>>
    private val repository: RoomCitiesRepository

    init {
        val citiesDao = AppDatabase.getDatabase(application).getCities()
        repository = RoomCitiesRepository(citiesDao)
        getCities = repository.getAllCities
    }

    fun addCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(city)
        }
    }
}