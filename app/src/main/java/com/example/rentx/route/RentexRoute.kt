package com.example.rentx.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rentx.screen.home.HomeScreen

@Composable
fun RentexRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RentexScreens.HomeScreen.name) {
        composable(RentexScreens.HomeScreen.name) {
            HomeScreen()
        }
    }
}