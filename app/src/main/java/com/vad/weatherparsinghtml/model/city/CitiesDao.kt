package com.vad.weatherparsinghtml.model.city

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vad.weatherparsinghtml.model.city.entities.City

@Dao
interface CitiesDao {

    @Query("SELECT * FROM cities ORDER BY id ASC")
    fun getAllCities(): LiveData<List<City>>

    @Query("SELECT * from cities WHERE name = :name")
    suspend fun findByName(name: String): City?

    @Update
    suspend fun updateCityName(city: City)

    @Insert
    suspend fun addCity(city: City)

    @Query("DELETE FROM cities WHERE id =:id")
    suspend fun deleteCity(id: Long): Int
}