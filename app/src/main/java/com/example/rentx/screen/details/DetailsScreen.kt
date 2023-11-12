package com.example.rentx.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.view.rowCar.Dots
import com.example.rentx.viewModel.CarsViewModel

@Composable
fun DetailsScreen(parentEntry: CarsViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 12.dp, vertical = 45.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                },
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Image icon back"
            )
            Row {
                parentEntry.selectedCar.value?.photos?.forEach {
                    Dots()
                }
            }

        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(parentEntry.selectedCar.value?.thumbnail).build(),
            contentDescription = "Image logo",
            contentScale = ContentScale.FillWidth
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column {
                parentEntry.selectedCar.value?.let {
                    Text(
                        text = it.brand,
                        fontFamily = fontArchivo,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Gray100]!!
                    )
                }
                parentEntry.selectedCar.value?.let {
                    Text(
                        text = it.name, fontFamily = fontArchivo,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Black100]!!
                    )
                }
            }
            Column {
                parentEntry.selectedCar.value?.let {
                    Text(
                        text = it.rentModel.period, fontFamily = fontArchivo,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Gray100]!!
                    )
                }
                parentEntry.selectedCar.value?.let {
                    Text(
                        text = "R$ ${it.rentModel.price}", fontFamily = fontArchivo,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Red]!!
                    )
                }
            }
        }

    }
}