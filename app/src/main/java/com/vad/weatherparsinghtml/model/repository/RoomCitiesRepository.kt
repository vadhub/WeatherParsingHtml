package com.vad.weatherparsinghtml.model.repository

import android.database.sqlite.SQLiteConstraintException
import com.vad.weatherparsinghtml.model.city.CitiesDao
import com.vad.weatherparsinghtml.model.city.entities.City

class RoomCitiesRepository(
    private val dao: CitiesDao
) {
    private suspend fun findCitiesByName(name: String): Long? {
        val city = dao.findByName(name)
        return city?.id
    }

    private suspend fun addCity(city: City) {
        try {
            dao.addCity(city)
        } catch (e: SQLiteConstraintException) {
            println(e.message)
        }
    }

    private suspend fun updateCity(city: City) {
        dao.updateCityName(city)
    }

    private suspend fun deleteCityById(id: Long) {
        dao.deleteCity(id)
    }
}