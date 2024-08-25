package com.bhandari.composeplayground.extensions

import android.annotation.SuppressLint
import kotlin.math.PI

// Function to convert degrees to radians
fun Float.degreesToRadians(): Float {
    return this * (PI / 180.0).toFloat()
}

fun Int.isDivisible(divisor: Int): Boolean {
    return divisor != 0 && this % divisor == 0
}

@SuppressLint("DefaultLocale")
fun Long.toHms(): String {
    val minutes = this / 60000
    val seconds = (this % 60000) / 1000
    val milliseconds = (this % 1000) / 10

    return String.format("%02d:%02d:%02d", minutes, seconds, milliseconds)
}

fun Long.toRange0To360(): Float {
    return this / 1000f * (360f / 60f)
}
