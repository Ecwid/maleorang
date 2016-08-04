package com.ecwid.maleorang

import com.ecwid.maleorang.util.DateUtil.formatDate
import com.ecwid.maleorang.util.DateUtil.parseDate
import org.testng.Assert.*
import org.testng.annotations.Test
import java.util.*


class DateUtilTest {
    @Test
    fun testParse() {
        println(formatDate(Date(0)))

        assertEquals(parseDate("1970-01-01T00:00:00Z"), Date(0))
        assertEquals(parseDate("1970-01-01T00:00:00+00:00"), Date(0))
        assertEquals(parseDate("1970-01-01T04:00:00+04:00"), Date(0))
    }

    @Test
    fun testFormat() {
        assertEquals(formatDate(Date(0)), "1970-01-01T00:00:00Z")
    }
}