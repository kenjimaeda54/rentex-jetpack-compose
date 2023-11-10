package com.example.rentx.utils

import androidx.room.TypeConverter
import com.example.rentx.model.AccessoriesModel
import com.example.rentx.modifier.fromJson
import com.google.gson.Gson

class ArrayListConverter {

    //nao aceita generico por isso esta sendo feito assim

    @TypeConverter
    fun fromAccessoriesArrayList(value: ArrayList<AccessoriesModel>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toAccessoriesArrayList(value: String): ArrayList<AccessoriesModel> {
        return try {
            Gson().fromJson<ArrayList<AccessoriesModel>>(value)
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    @TypeConverter
    fun fromStringArrayList(value: ArrayList<String>): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value: String): ArrayList<String> {
        return try {
            Gson().fromJson<ArrayList<String>>(value)
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}