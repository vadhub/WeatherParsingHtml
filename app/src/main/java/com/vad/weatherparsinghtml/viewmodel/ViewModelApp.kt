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

class ViewModelApp(private val application: Application ,private val repositoryApi: RepositoryApi) : ViewModel() {

    private val repository: RoomCitiesRepository
    val readAllData: LiveData<List<City>>

    val myResponse: MutableLiveData<Response<Main>> = MutableLiveData()

    init {
        val citiesDao = AppDatabase.getDatabase(application).getCities()
        repository = RoomCitiesRepository(citiesDao)
        readAllData = repository.getAllCities
    }

    fun getWeather(q: String) {
        viewModelScope.launch {
            val response = repositoryApi.getWeather(q)
            myResponse.value = response
        }
    }

    fun addCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(city)
        }
    }
}