package com.example.rentx.route

import java.lang.IllegalArgumentException

enum class RentexScreens {
    HomeScreen,
    DetailsScreen,
    ScheduleScreen,
    DetailsPayment,
    FinishedScreen;

    companion object {
        fun fromRoute(route: String): RentexScreens = when (route.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            ScheduleScreen.name -> ScheduleScreen
            DetailsPayment.name -> DetailsPayment
            FinishedScreen.name -> FinishedScreen
            else -> throw IllegalArgumentException("Route $route is not recognizable")
        }
    }
}