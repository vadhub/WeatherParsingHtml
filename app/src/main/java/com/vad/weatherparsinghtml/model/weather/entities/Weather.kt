package com.vad.weatherparsinghtml.model.weather.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.vad.weatherparsinghtml.model.city.entities.City
import java.util.*

@Entity(
    tableName = "Weather",
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = ["id"],
            childColumns = ["city_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Weather(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "city_id") val cityId: Long,
    val weather: Int,
    val date: Date
) {
}