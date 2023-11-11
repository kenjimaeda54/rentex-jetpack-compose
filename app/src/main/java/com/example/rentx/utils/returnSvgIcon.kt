package com.example.rentx.utils

import com.example.rentx.R

fun returnSvgIcon(name: String): Int {

    return when (name) {
        "gasoline_motor" -> R.drawable.gasoline_motor
        else -> R.drawable.electric

    }


}