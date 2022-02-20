package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vad.weatherparsinghtml.model.api.pojo.Main
import com.vad.weatherparsinghtml.model.api.repository.RepositoryApi
import com.vad.weatherparsinghtml.model.room.AppDatabase
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather
import com.vad.weatherparsinghtml.model.room.weather.repository.RoomWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelWeathers(private val application: Application, private val repositoryApi: RepositoryApi): ViewModel() {
    private val repository: RoomWeatherRepository
    val readAllData: LiveData<List<Weather>>
    val myResponse: MutableLiveData<Response<Main>> = MutableLiveData()

    init {
        val dao = AppDatabase.getDatabase(application).getWeathersDao()

        repository = RoomWeatherRepository(dao)
        readAllData = repository.getAllWeather
    }

    fun getWeather(q: String) {
        viewModelScope.launch {
            val response = repositoryApi.getWeather(q)
            myResponse.value = response
        }
    }

    fun addWeather(weather: Weather) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWeather(weather)
        }
    }
}