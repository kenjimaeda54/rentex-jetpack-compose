package com.example.rentx.utility

interface UserCache {

    fun saveToken(token: String)

    fun getToken(): String?


    
}