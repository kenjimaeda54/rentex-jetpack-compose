package com.example.rentx.model

data class CarsModel(
    val about: String,
    val accessories: List<Accessory>,
    val brand: String,
    val fuel_type: String,
    val id: String,
    val name: String,
    val photos: List<String>,
    val rent: Rent,
    val thumbnail: String

)