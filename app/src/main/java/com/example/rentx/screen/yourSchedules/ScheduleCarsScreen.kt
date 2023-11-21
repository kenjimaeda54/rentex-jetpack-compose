package com.example.rentx.screen.yourSchedules

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rentx.R
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.view.rowCar.RowCar
import com.example.rentx.viewModel.UserViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleCarsScreen(userViewModel: UserViewModel = hiltViewModel()) {


    if (userViewModel.dataSchedulesCarByUser.value.loading == true || userViewModel.dataSchedulesCarByUser.value.exception != null) {
        Text(text = "loading")
    } else {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                Surface(
                    modifier = Modifier
                        .height(273.dp)
                        .fillMaxWidth(), color = colorsApp[ColorApp.Black100]!!
                ) {
                    Column(
                        modifier = Modifier.padding(
                            bottom = 34.dp,
                            top = 12.dp,
                            end = 12.dp,
                            start = 12.dp
                        ),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Button Back",
                            colorFilter = ColorFilter.tint(color = colorsApp[ColorApp.White]!!)
                        )
                        Text(
                            text = "Seus agendamentos,\n" +
                                    "estão aqui.",
                            fontFamily = fontArchivo,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp,
                            lineHeight = 34.sp,
                            color = colorsApp[ColorApp.White]!!
                        )
                        Text(
                            text = "Conforto, segurança e praticidade.",
                            fontFamily = fontArchivo,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorsApp[ColorApp.White]!!
                        )
                    }
                }

            }) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .background(colorsApp[ColorApp.Gray100]!!.copy(0.2f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 24.dp),
                        text = "Agendamento feito ",
                        fontFamily = fontInter,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorsApp[ColorApp.Gray200]!!
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 24.dp),
                        text = "2",
                        fontFamily = fontArchivo,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        color = colorsApp[ColorApp.Black200]!!
                    )
                }


                Column(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .verticalScroll(
                            rememberScrollState()
                        ),

                    ) {
                    userViewModel.dataSchedulesCarByUser.value.data?.scheduleCar!!.forEach { scheduleCar ->
                        val formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        val dateTimeStart = LocalDate.parse(scheduleCar.startDate, formatDateTime)
                        val dateTimeEnd = LocalDate.parse(scheduleCar.endDate, formatDateTime)
                        Column(modifier = Modifier.padding(vertical = 16.dp)) {
                            RowCar(
                                carsModel = scheduleCar.car,
                                modifier = Modifier.padding(vertical = 3.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 17.dp)
                                    .background(colorsApp[ColorApp.White]!!),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        horizontal = 15.dp,
                                        vertical = 15.dp
                                    ),
                                    text = "Período".uppercase(Locale.ROOT),
                                    fontFamily = fontArchivo,
                                    fontSize = 10.sp,
                                    color = colorsApp[ColorApp.Gray150]!!,
                                    fontWeight = FontWeight.W500
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 24.dp,
                                            vertical = 15.dp
                                        )
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = dateTimeStart.toString(),
                                        fontFamily = fontInter,
                                        fontWeight = FontWeight.W400,
                                        fontSize = 13.sp,
                                        color = colorsApp[ColorApp.Black100]!!
                                    )
                                    Image(
                                        modifier = Modifier.size(14.dp),
                                        painter = painterResource(id = R.drawable.arrow_large),
                                        contentDescription = "Large Row",
                                        colorFilter = ColorFilter.tint(
                                            colorsApp[ColorApp.Gray150]!!
                                        )
                                    )
                                    Text(
                                        text = dateTimeEnd.toString(),
                                        fontFamily = fontInter,
                                        fontWeight = FontWeight.W400,
                                        fontSize = 13.sp,
                                        color = colorsApp[ColorApp.Black100]!!
                                    )
                                }
                            }


                        }
                    }
                }

            }
        }
    }


}
