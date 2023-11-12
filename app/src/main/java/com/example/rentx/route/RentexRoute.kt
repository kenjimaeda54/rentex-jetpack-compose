package com.example.rentx.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rentx.screen.details.DetailsScreen
import com.example.rentx.screen.home.HomeScreen
import com.example.rentx.viewModel.CarsViewModel

@Composable
fun RentexRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RentexScreens.HomeScreen.name) {
        composable(RentexScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(RentexScreens.DetailsScreen.name) {entry ->
            val parentEntry = remember(entry) {
                navController.getBackStackEntry(RentexScreens.HomeScreen.name)
            }
            val parentViewModel = hiltViewModel<CarsViewModel>(parentEntry)
            DetailsScreen(parentViewModel,navController)
        }
    }
}