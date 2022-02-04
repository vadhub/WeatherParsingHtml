package com.vad.weatherparsinghtml.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location (
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,

    @SerializedName("tz_id")
    @Expose
    val tzID: String,

    @SerializedName("localtime_epoch")
    @Expose
    val localtimeEpoch: Long,

    val localtime: String
)