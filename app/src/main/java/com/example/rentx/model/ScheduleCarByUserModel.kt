package com.example.rentx.model

data class ScheduleCarByUserModel(
    var id: String,
    var scheduleCar: List<ScheduleCar>
)

data class ScheduleCar(
    val car: CarsModel,
    var startDate: String,
    var endDate: String
)

