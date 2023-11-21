package com.example.rentx.screen.rentedCar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.rentx.R
import com.example.rentx.model.ScheduleCar
import com.example.rentx.model.ScheduleCarByUserModel
import com.example.rentx.model.SchedulesModel
import com.example.rentx.route.RentexScreens
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.utility.ComposableLifecycle
import com.example.rentx.utility.formatDateTime
import com.example.rentx.viewModel.CarsViewModel
import com.example.rentx.viewModel.ScheduleViewModel
import com.example.rentx.viewModel.UserViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RentedCarScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorsApp[ColorApp.Black100]!!),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Surface(
            modifier = Modifier
                .width(60.dp)
                .height(66.dp)
                .border(width = 4.dp, color = colorsApp[ColorApp.Black150]!!),
            color = Color.Transparent
        ) {
            Image(
                modifier = Modifier
                    .size(28.dp)
                    .padding(horizontal = 10.dp, vertical = 12.dp),
                painter = painterResource(id = R.drawable.done),
                contentDescription = "Icon done"
            )
        }
        Spacer(modifier = Modifier.height(49.dp))
        Text(
            text = "Carro alugado!",
            fontFamily = fontArchivo,
            fontSize = 30.sp,
            color = colorsApp[ColorApp.White]!!,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = "Agora você só precisa ir\n" +
                    "até a concessionária da RENTX\n" +
                    "pegar o seu automóvel.",
            fontFamily = fontInter,
            fontSize = 15.sp,
            color = colorsApp[ColorApp.Gray150]!!,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.padding(bottom = 50.dp),
            onClick = { navController.navigate(RentexScreens.HomeScreen.name) },
            shape = RectangleShape,
            contentPadding = PaddingValues(vertical = 19.dp, horizontal = 21.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorsApp[ColorApp.Black150]!!
            )
        ) {
            Text(text = "OK")
        }
    }
}

