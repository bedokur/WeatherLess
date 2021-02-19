package com.example.weatherless.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeStampToDate {

    fun convertLongToTime(time: Long): String {
        val date = Date(time * 1000)
        val format = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        return format.format(date)
    }
}