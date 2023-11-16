package com.example.rentx.data

data class DataOrException<T, Boll, E : Exception>(
    var data: T? = null,
    var loading: Boll? = null,
    var exception: E? = null
)
