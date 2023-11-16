package com.example.rentx.service

import com.example.rentx.model.CarsModel
import com.example.rentx.model.Schedules
import retrofit2.http.GET
import retrofit2.http.Query

interface RentexServiceApi {

    @GET("/cars")
    suspend fun getAllCars(): List<CarsModel>


    @GET("/schedules_bycars")
    suspend fun getSchedulesByCar(
        @Query("id") id: String
    ): List<Schedules>

}