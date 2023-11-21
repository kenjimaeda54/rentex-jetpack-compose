package com.example.rentx.repository

import android.util.Log
import com.example.rentx.data.DataOrException
import com.example.rentx.model.CarsModel
import com.example.rentx.model.ScheduleCarByUserModel
import com.example.rentx.model.SchedulesModel
import com.example.rentx.service.RentexServiceApi

import javax.inject.Inject

class ApiRepository @Inject constructor(private val rentexServiceApi: RentexServiceApi) {

    suspend fun getCars(): DataOrException<List<CarsModel>, Boolean, Exception> {
        val data = try {
            rentexServiceApi.getAllCars()
        } catch (e: Exception) {
            Log.d("exception", e.toString())
            return DataOrException(exception = e)
        }

        return DataOrException(data = data)
    }


    suspend fun getSchedulesByCar(id: String): DataOrException<SchedulesModel, Boolean, Exception> {
        val data = try {
            rentexServiceApi.getSchedulesByCar(id)
        } catch (e: Exception) {
            Log.d("exception", e.toString())
            return DataOrException(exception = e)
        }
        return DataOrException(data = data[0])
    }


    suspend fun createScheduleByUser(schedulesUser: ScheduleCarByUserModel) {
        try {
            rentexServiceApi.createScheduleCarByUser(schedulesUser)
        } catch (e: Exception) {
            Log.d("exception", e.toString())
        }
    }

    suspend fun updateSchedulesDates(carId: String,schedulesModel: SchedulesModel) {
        try {
            rentexServiceApi.updateDatesUnavailable(carId,schedulesModel)
        } catch (e: Exception) {
            Log.d("exception", e.toString())
        }
    }

    suspend fun getScheduleByUser(userId: String): DataOrException<ScheduleCarByUserModel, Boolean, Exception> {
        val data = try {
            rentexServiceApi.getSchedulesCarByUser(userId)
        } catch (e: Exception) {
            Log.d("exception", e.toString())
            return DataOrException(exception = e)
        }
        return DataOrException(data = data)
    }


    suspend fun updateScheduleCarByUser(userId: String,carByUserModel: ScheduleCarByUserModel) {
        try {
            rentexServiceApi.updateListCarsUserSchedule(userId,carByUserModel)
        }catch (e: Exception) {
            Log.d("exception", e.toString())
        }
    }
}