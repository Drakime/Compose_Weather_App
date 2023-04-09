package com.example.compose_weather_app.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class DateUtils {

    // Code adapted from Rahul Khatri, from StackOverflow
    // https://stackoverflow.com/a/67418587
    //
    // Returns a list of dates between two dates, as list collection
    fun getDates(inputDate: LocalDate = LocalDate.now()): List<String> {
        var dates = ArrayList<String>()
        val input = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val startDate = inputDate.toString()
        val endDate = inputDate.plusDays(6).toString()
        var date1: Date? = null
        var date2: Date? = null

        try {
            date1 = input.parse(startDate)
            date2 = input.parse(endDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val cal1 = Calendar.getInstance()
        cal1.time = date1
        val cal2 = Calendar.getInstance()
        cal2.time = date2

        while (!cal1.after(cal2)) {
            val output = SimpleDateFormat("d/M", Locale.getDefault())
            dates.add(output.format(cal1.time))
            cal1.add(Calendar.DATE, 1)
        }

        return dates
    }

}