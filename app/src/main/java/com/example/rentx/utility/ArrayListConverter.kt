package com.example.rentx.utilit


//
// class ArrayListConverter {

//      para salvar uma data class dentro do room pode tranformar em string usando json e depois recuperar,exemplo abaixo

//     @TypeConverter
//     fun fromAccessoriesArrayList(value: ArrayList<AccessoriesModel>): String {
//         return Gson().toJson(value)
//     }

//     @TypeConverter
//     fun toAccessoriesArrayList(value: String): ArrayList<AccessoriesModel> {
//         return try {
//             Gson().fromJson<ArrayList<AccessoriesModel>>(value)
//         } catch (e: Exception) {
//             arrayListOf()
//         }
//     }

//     @TypeConverter
//     fun fromStringArrayList(value: ArrayList<String>): String {

//         return Gson().toJson(value)
//     }

//     @TypeConverter
//     fun toStringArrayList(value: String): ArrayList<String> {
//         return try {
//             Gson().fromJson<ArrayList<String>>(value)
//         } catch (e: Exception) {
//             arrayListOf()
//         }
//     }
