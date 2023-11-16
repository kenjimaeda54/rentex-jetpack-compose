package com.example.rentx.route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rentx.screen.details.DetailsScreen
import com.example.rentx.screen.home.HomeScreen
import com.example.rentx.screen.schedules.ScheduleScreen
import com.example.rentx.screen.schedulesDetails.SchedulesDetailsScreen
import com.example.rentx.viewModel.CarsViewModel
import com.example.rentx.viewModel.ScheduleViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RentexRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RentexScreens.HomeScreen.name) {
        composable(RentexScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(RentexScreens.DetailsScreen.name) { entry ->
            val parentEntry = remember(entry) {
                navController.getBackStackEntry(RentexScreens.HomeScreen.name)
            }
            val parentViewModel = hiltViewModel<CarsViewModel>(parentEntry)
            DetailsScreen(parentViewModel, navController)
        }

        composable(RentexScreens.ScheduleScreen.name) { entry ->
            val parentEntry = remember(entry) {
                navController.getBackStackEntry(RentexScreens.HomeScreen.name)
            }
            val parentViewModel = hiltViewModel<CarsViewModel>(parentEntry)
            ScheduleScreen(navController, parentViewModel)
        }

        composable(RentexScreens.ScheduleDetailsScreen.name) { entry ->
            val parentEntryHome = remember(entry) {
                navController.getBackStackEntry(RentexScreens.HomeScreen.name)
            }
            val parentEntrySchedule = remember(entry) {
                navController.getBackStackEntry(RentexScreens.ScheduleScreen.name)
            }
            val parentCarViewModel = hiltViewModel<CarsViewModel>(parentEntryHome)
            val parentScheduleViewModel = hiltViewModel<ScheduleViewModel>(parentEntrySchedule)
            SchedulesDetailsScreen(parentCarViewModel, navController, parentScheduleViewModel)
        }
    }
}