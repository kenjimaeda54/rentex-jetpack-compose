package com.example.rentx.service

import com.example.rentx.model.CarsModel
import com.example.rentx.model.ScheduleCarByUserModel
import com.example.rentx.model.SchedulesModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RentexServiceApi {

    @GET("/cars")
    suspend fun getAllCars(): List<CarsModel>


    @GET("/schedules_bycars")
    suspend fun getSchedulesByCar(
        @Query("id") id: String
    ): List<SchedulesModel>


    @PATCH("/schedules_bycars/{carId}")
    suspend fun updateDatesUnavailable(
        @Path("carId") carId: String,
        @Body schedulesModel: SchedulesModel
    )

    @GET("/schedules_byuser/{userId}")
    suspend fun getSchedulesCarByUser(
        @Path("userId") userId: String
    ): ScheduleCarByUserModel

    @PATCH("/schedules_byuser/{userId}")
    suspend fun updateListCarsUserSchedule(
        @Path("userId") userId: String,
        @Body carByUserModel: ScheduleCarByUserModel
    )

    @POST("/schedules_byuser")
    suspend fun createScheduleCarByUser(
        @Body schedulesCarByUserModel: ScheduleCarByUserModel
    )


}