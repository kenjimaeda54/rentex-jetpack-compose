package com.example.rentx.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "rent")
data class RentModel(
    @PrimaryKey
    val rentId: String = UUID.randomUUID().toString(),
    val period: String,
    val price: Int
)
