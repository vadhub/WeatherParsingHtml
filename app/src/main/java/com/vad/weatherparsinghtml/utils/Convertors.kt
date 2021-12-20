package com.vad.weatherparsinghtml.utils

import androidx.room.TypeConverter
import java.util.*

class Convertors {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(value) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}