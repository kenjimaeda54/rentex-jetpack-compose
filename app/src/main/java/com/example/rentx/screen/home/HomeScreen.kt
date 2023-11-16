package com.example.rentx.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.rentx.R
import com.example.rentx.route.RentexScreens
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.utility.ComposableLifecycle
import com.example.rentx.view.rowCar.RowCar
import com.example.rentx.viewModel.CarsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(carsViewModel: CarsViewModel = hiltViewModel(), navController: NavController) {

    ComposableLifecycle { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            carsViewModel.getAllCar()
        }
    }


//    val car = CarsModel(
//        brand = "Mitsubishi",
//        name = "Lancer",
//        about = "Mitsubishi Lancer é um belo e agressivo carro. Além do mais, ele encanta pelo conforto e pela eficiência. Bastante firme e estável para dirigir com tranquilidade e segurança.",
//        fuelType = "hybrid_motor",
//        rentModel =
//        RentModel(
//            period = "Ao dia",
//            price = 220
//        ),
//        thumbnail = "https://storage.googleapis.com/golden-wind/ignite/react-native/thumbnails/6.png",
//        accessoriesJson = arrayListOf(
//            AccessoriesModel(
//                type = "speed",
//                name = "180km/h"
//            ),
//            AccessoriesModel(
//                type = "acceleration",
//                name = "2.0s"
//            ),
//            AccessoriesModel(
//                type = "turning_diameter",
//                name = "600 HP"
//            ),
//            AccessoriesModel(
//
//                type = "hybrid_motor",
//                name = "Híbrido"
//            ),
//            AccessoriesModel(
//                type = "exchange",
//                name = "Auto"
//            ),
//            AccessoriesModel(
//                type = "seats",
//                name = "5 pessoas"
//            )
//        ),
//        photos = arrayListOf(
//            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/15.png",
//            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/16.png",
//            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/17.png"
//
//        )
//    )


    if(carsViewModel.dataCars.value.loading!! || carsViewModel.dataCars.value.exception != null ){
        Text(text = "loading")
    } else {
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
                        text = "Total de carros ${carsViewModel.dataCars.value.data?.size}",
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
                items(carsViewModel.dataCars.value.data!!) { car ->
                    RowCar(modifier = Modifier.clickable {
                        carsViewModel.handleSelectedCar(car)
                        navController.navigate(RentexScreens.DetailsScreen.name)
                    }, carsModel = car)
                }

            }

        }
    }

}

