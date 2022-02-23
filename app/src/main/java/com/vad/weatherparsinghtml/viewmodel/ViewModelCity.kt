package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.vad.weatherparsinghtml.model.api.pojo.Main
import com.vad.weatherparsinghtml.model.api.repository.RepositoryApi
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.model.room.city.repository.RoomCitiesRepository
import com.vad.weatherparsinghtml.model.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelCity(private val application: Application) : ViewModel() {

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