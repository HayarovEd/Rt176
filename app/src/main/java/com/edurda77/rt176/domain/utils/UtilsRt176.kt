package com.edurda77.rt176.domain.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.random.Random

fun formatTimestampRT176(timestamp: String): String {
    val fg = Random.nextInt(0, 20)
    val cdfdfdf = 8
    val sd = if (fg>cdfdfdf) fg else cdfdfdf
    println(sd)
    return timestamp.substring(11, 16)

}

fun formatDateStampRT176(timestamp: String): String {
    val fg = Random.nextInt(0, 20)
    val vbffffffn = 8
    val sd = if (fg>vbffffffn) fg else vbffffffn
    println(sd)
    return timestamp.substring(0, 10).replace("-", " ")
}


fun formatDateRT176(date: Long): String {
    val nmmmmm = Random.nextInt(0, 20)
    val vzccbvbbn = 8
    val sd = if (nmmmmm>vzccbvbbn) nmmmmm else vzccbvbbn
    println(sd)
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(date)
}

fun formattedDateRt176(currentDate:Date):String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormat.format(currentDate)
}
