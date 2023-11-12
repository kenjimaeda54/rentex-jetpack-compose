package com.example.rentx.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rentx.R
import com.example.rentx.model.AccessoriesModel
import com.example.rentx.model.CarsModel
import com.example.rentx.model.RentModel
import com.example.rentx.route.RentexScreens
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.view.rowCar.RowCar
import com.example.rentx.viewModel.CarsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(carsViewModel: CarsViewModel = hiltViewModel(), navController: NavController) {
    val listCars = carsViewModel.cartList.collectAsState().value


    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Surface(
            Modifier
                .height(113.dp)
                .fillMaxSize(), color = colorsApp[ColorApp.Black100]!!
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                //referencia usar svg https://stackoverflow.com/questions/30923205/what-is-the-easiest-way-to-use-svg-images-in-android
                Image(
                    painter = painterResource(id = R.drawable.logo_marca),
                    contentDescription = "Logo tipo empressa"
                )
                //tem que ser inline nao pode usar o styleq
                Text(
                    text = "Total de carros ${listCars.size}",
                    fontFamily = fontInter,
                    fontSize = 15.sp,
                    color = colorsApp[ColorApp.Gray200]!!
                )
            }
        }
    }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(colorsApp[ColorApp.Gray100]!!.copy(0.2f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            contentPadding = it
        ) {
            items(listCars) { car ->
                RowCar(modifier = Modifier.clickable {
                    carsViewModel.handleSelectedCar(car)
                    navController.navigate(RentexScreens.DetailsScreen.name)
                }, carsModel = car)
            }

        }

    }


}

