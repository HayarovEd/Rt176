package com.edurda77.rt176.domain.utils

import android.graphics.Color
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import kotlin.random.Random


fun LocalDate.formattedDateRt176():String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return this.format(formatter)
}

fun LocalDate.dayOfWeek(): String {
    return this.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
}

fun LocalDate.formattedDateDMMM(): String {
    val formatter = DateTimeFormatter.ofPattern("d MMM")
    return this.format(formatter)
}

fun generateRandomColorRt175(): Int {
    val random = Random.Default
    return Color.rgb(
        random.nextInt(256),
        random.nextInt(256),
        random.nextInt(256)
    )
}