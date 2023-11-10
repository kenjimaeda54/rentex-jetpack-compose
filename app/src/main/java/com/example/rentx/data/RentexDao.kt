package com.example.rentx.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rentx.model.CarsModel
import kotlinx.coroutines.flow.Flow


@Dao
interface RentexDao {

    @Query("SELECT * from cars")
    fun getAllCars(): Flow<List<CarsModel>>


}