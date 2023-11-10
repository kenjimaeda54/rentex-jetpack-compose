package com.example.rentx.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


data class AccessoriesModel(
    val type: String,
    val name: String
)
