package com.example.history.presentation.util

fun formatViewedAt(timestamp: Long): String {
    val date = java.text.SimpleDateFormat(
        "MMM dd, yyyy",
        java.util.Locale.getDefault()
    ).format(java.util.Date(timestamp))

    return "Viewed $date"
}