package com.example.rentx.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rentx.model.CarsModel
import kotlinx.coroutines.flow.Flow


@Dao
interface RentexDao {

    @Query("SELECT * from cars")
    fun getAllCars(): Flow<List<CarsModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCar(carModel: CarsModel)

    @Delete
    suspend fun deleteSingleCar(carsModel: CarsModel)
}