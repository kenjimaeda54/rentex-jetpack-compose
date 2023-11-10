package com.example.rentx.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rentx.model.AccessoriesModel
import com.example.rentx.model.CarsModel
import com.example.rentx.model.RentModel
import com.example.rentx.utils.ArrayListConverter


@Database(
    entities = [CarsModel::class,RentModel::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(ArrayListConverter::class)
abstract class RentexDatabase : RoomDatabase() {
    abstract fun RentexDao(): RentexDao
}