package com.vad.weatherparsinghtml.model.api

import com.vad.weatherparsinghtml.model.api.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api: ApiRetrofitService by lazy {
        retrofit.create(ApiRetrofitService::class.java)
    }
}