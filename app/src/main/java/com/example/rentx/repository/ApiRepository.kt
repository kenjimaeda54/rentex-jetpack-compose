package com.example.rentx.repository

import android.util.Log
import com.example.rentx.data.DataOrException
import com.example.rentx.model.CarsModel
import com.example.rentx.model.Schedules
import com.example.rentx.service.RentexServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

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


    suspend fun getSchedulesByCar(id: String): DataOrException<Schedules, Boolean, Exception> {
        val data = try {
            rentexServiceApi.getSchedulesByCar(id)
        } catch (e: Exception) {
            Log.d("exception", e.toString())
            return DataOrException(exception = e)
        }
        return DataOrException(data = data[0])
    }

}