package com.bj.ocean.jetpack.data

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by ocean on 2020-04-16
 * @describe:
 */
class Converters {
    @TypeConverter
    fun calendarToDate(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun dateTocalendar(value: Long): Calendar = Calendar.getInstance().apply { timeInMillis = value }
}