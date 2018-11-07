package com.ecwid.maleorang.util

import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat
import java.util.*

internal object DateUtil {
    private val format = ISODateTimeFormat.dateTimeNoMillis().withZone(DateTimeZone.UTC)
    fun formatDate(date: Date) = format.print(date.time)
    fun parseDate(string: String) = Date(format.parseMillis(string))
}
