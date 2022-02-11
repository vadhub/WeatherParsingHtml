package com.vad.weatherparsinghtml.model.api.repository

import androidx.lifecycle.LiveData
import com.vad.weatherparsinghtml.model.api.RetrofitInstance
import com.vad.weatherparsinghtml.model.api.pojo.Main

import com.vad.weatherparsinghtml.model.api.utils.Constants.Companion.API_KEY
import retrofit2.Response

class RepositoryApi {
    suspend fun getWeather(q: String): Response<Main> {
        return RetrofitInstance.api.getWeather(API_KEY, q, "no")
    }
}