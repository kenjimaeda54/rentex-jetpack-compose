package com.example.rentx.repository

import com.example.rentx.data.RentexDao
import com.example.rentx.model.CarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val rentexDao: RentexDao) {


    suspend fun get(): Flow<List<CarsModel>> =
        rentexDao.getAllCars().flowOn(Dispatchers.IO).conflate()


    suspend fun addCar(carModel: CarsModel) = rentexDao.addCar(carModel)

    suspend fun deleteCar(carModel: CarsModel) = rentexDao.deleteSingleCar(carModel)
}