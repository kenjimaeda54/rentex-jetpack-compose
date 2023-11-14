package com.example.rentx.utils

import com.example.rentx.R

fun returnSvgIcon(name: String): Int {

    return when (name) {
        "gasoline_motor" -> R.drawable.gasoline_motor
        "speed" -> R.drawable.speed
        "acceleration" -> R.drawable.acceleration
        "turning_diameter" -> R.drawable.turning_diameter
        "seats" -> R.drawable.seats
        else -> R.drawable.electric

    }


}