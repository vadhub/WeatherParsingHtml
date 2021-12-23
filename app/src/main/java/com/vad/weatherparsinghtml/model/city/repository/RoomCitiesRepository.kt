package com.vad.weatherparsinghtml.model.city.repository

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import com.vad.weatherparsinghtml.model.city.CitiesDao
import com.vad.weatherparsinghtml.model.city.entities.City

class RoomCitiesRepository(
    private val dao: CitiesDao
) {

    val getAllCities: LiveData<List<City>> = dao.getAllCities()

    suspend fun findCitiesByName(name: String): Long? {
        val city = dao.findByName(name)
        return city?.idCity
    }

    suspend fun addCity(city: City) {
        try {
            dao.addCity(city)
        } catch (e: SQLiteConstraintException) {
            println(e.message)
        }
    }

    suspend fun updateCity(city: City) {
        dao.updateCityName(city)
    }

    suspend fun deleteCityById(id: Long) {
        dao.deleteCity(id)
    }
}