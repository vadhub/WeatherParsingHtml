package com.vad.weatherparsinghtml.model.api

import androidx.lifecycle.LiveData
import com.vad.weatherparsinghtml.model.api.pojo.Main
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofitService {
    @GET("v1/current.json")
    suspend fun getWeather(@Query("key") key: String, @Query("q") q: String, @Query("aqi") aqi: String): Main
}