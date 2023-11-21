package com.example.rentx.route

import java.lang.IllegalArgumentException

enum class RentexScreens {
    HomeScreen,
    DetailsScreen,
    ScheduleScreen,
    ScheduleDetailsScreen,
    ScheduleCarsScreen,
    RentedCar;

    companion object {
        fun fromRoute(route: String): RentexScreens = when (route.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            ScheduleScreen.name -> ScheduleScreen
            ScheduleDetailsScreen.name -> ScheduleDetailsScreen
            ScheduleCarsScreen.name -> ScheduleCarsScreen
            RentedCar.name -> RentedCar
            else -> throw IllegalArgumentException("Route $route is not recognizable")
        }
    }
}