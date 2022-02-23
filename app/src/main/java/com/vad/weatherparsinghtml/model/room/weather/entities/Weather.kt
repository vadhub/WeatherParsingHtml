package com.vad.weatherparsinghtml.model.room.weather.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.vad.weatherparsinghtml.model.room.city.entities.City
import java.util.*

@Entity(
    tableName = "Weather",
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = ["id_city"],
            childColumns = ["city_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Weather(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_weather")
    val idWeather: Long,

    @ColumnInfo(name = "city_id")
    val cityId: Long,
    val weather: Float,
    val date: Long
) {
}