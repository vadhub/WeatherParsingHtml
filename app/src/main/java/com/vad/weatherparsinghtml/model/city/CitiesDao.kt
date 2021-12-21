package com.vad.weatherparsinghtml.model.city

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vad.weatherparsinghtml.model.city.entities.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CitiesDao {

    @Query("SELECT * FROM cities ORDER BY id ASC")
    suspend fun getAll(): LiveData<List<City>>

    @Query("SELECT * from cities WHERE name = :name")
    suspend fun findByName(name: String): City?

    @Update
    suspend fun updateCityName(city: City)

    suspend fun addCity(city: City)

    @Query("DELETE FROM cities WHERE id =:id")
    suspend fun deleteCity(id: Long): Int
}