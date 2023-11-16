package com.example.rentx.utility

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(date: Temporal): String {
    val formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return formatDateTime.format(date)
}

