package com.example.rentx.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rentx.model.AccessoriesModel
import com.example.rentx.model.CarsModel
import com.example.rentx.model.RentModel
import com.example.rentx.viewModel.CarsViewModel


@Composable
fun HomeScreen(carsViewModel: CarsViewModel = hiltViewModel()) {
    val listCars = carsViewModel.cartList.collectAsState().value
   


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }

}