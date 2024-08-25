package com.bhandari.composeplayground.extensions

import android.annotation.SuppressLint
import kotlin.math.PI

val Any.TAG: String
    get() = this::class.simpleName ?: "UnknownClass"

// Function to convert degrees to radians
fun Float.degreesToRadians(): Float {
    return this * (PI / 180.0).toFloat()
}

fun Int.isDivisible(divisor: Int): Boolean {
    return divisor != 0 && this % divisor == 0
}

@SuppressLint("DefaultLocale")
fun Long.toHms(): String {
    val hours = this / 3600000
    val minutes = (this % 3600000) / 60000
    val seconds = (this % 60000) / 1000

    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}
