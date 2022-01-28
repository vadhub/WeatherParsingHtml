package com.vad.weatherparsinghtml.model.city.entities

import androidx.room.*

@Entity(
    tableName = "cities",
    indices = [
        Index("name_city", unique = true) //unique name city
    ]
)
data class City(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_city")
    val idCity: Long,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "name_city")
    val nameCity: String //Abg == abg
)