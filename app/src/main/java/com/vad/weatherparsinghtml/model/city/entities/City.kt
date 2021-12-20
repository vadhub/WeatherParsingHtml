package com.vad.weatherparsinghtml.model.city.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cities",
    indices = [
        Index("name", unique = true) //unique name city
    ]
)
data class City(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idCity: Long,

    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val name: String //Abg == abg
) {
}