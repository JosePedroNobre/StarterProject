package com.josenobre.starterproject.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date
import java.util.TimeZone
import javax.inject.Inject

/**
 * @context This utility class allows the user convert any string to the data type
 */
class DateManager @Inject constructor() {

    companion object {
        const val DATE_FORMAT_NUMERIC = "dd/MM/yy"
        const val DATE_FORMAT_WEEK = "EEE"
        const val DATE_FORMAT_DAY_MONTH = "dd/MM"

        const val DATE_FORMAT_HOUR = "HH:mm"
        const val DATE_FORMAT_TIME_REMAINING = "H'h' m'm'"
    }

    private val locale: Locale by lazy {
        Locale("pt", "PT")
    }

    fun convert(date: Date?, format: String): String {
        val dateFormat = SimpleDateFormat(format, locale)
        return dateFormat.format(date)
    }

    fun convert(time: Long?, format: String): String {
        val date = Date(time ?: return "")
        val dateFormat = SimpleDateFormat(format, locale)
        return dateFormat.format(date)
    }

    fun convert(time: Long?, format: String, timeZone: TimeZone): String {
        val date = Date(time ?: return "")
        val dateFormat = SimpleDateFormat(format, locale)
        dateFormat.timeZone = timeZone
        return dateFormat.format(date)
    }
}