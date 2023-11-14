package com.example.rentx.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rentx.route.RentexScreens
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.utils.returnSvgIcon
import com.example.rentx.view.buttonCommon.ButtonCommon
import com.example.rentx.view.rowCar.Dots
import com.example.rentx.view.rowDetailsCar.RowDetailsCar
import com.example.rentx.viewModel.CarsViewModel

@Composable
fun DetailsScreen(parentEntry: CarsViewModel, navController: NavController) {
    var indexSelected by remember {
        mutableIntStateOf(0)
    }
    val photoCar by remember(indexSelected) {
        mutableStateOf(parentEntry.selectedCar.value?.photos?.get(indexSelected))
    }


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 45.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
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
                parentEntry.selectedCar.value?.photos?.forEachIndexed { index, _ ->
                    Spacer(modifier = Modifier.width(10.dp))
                    Dots(
                        modifier = Modifier.clickable { indexSelected = index },
                        colorApp = if (index == indexSelected) colorsApp[ColorApp.Black100]!! else colorsApp[ColorApp.Gray200]!!
                    )
                }
            }

        }

        AsyncImage(
            modifier = Modifier
                .height(134.dp)
                .fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(photoCar).build(),
            contentDescription = "Image logo",
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            filterQuality = FilterQuality.High
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
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
        LazyHorizontalGrid(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            rows = GridCells.Adaptive(minSize = 100.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            parentEntry.selectedCar.value?.let {
                items(it.accessoriesJson) { accessory ->
                    RowDetailsCar(
                        idPainter = returnSvgIcon(accessory.type),
                        description = accessory.name
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 24.dp))
        parentEntry.selectedCar.value?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                text = it.about,
                fontFamily = fontInter,
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = colorsApp[ColorApp.Gray200]!!
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 50.dp))
        Surface(modifier = Modifier.height(111.dp), color = colorsApp[ColorApp.Gray100]!!) {
            ButtonCommon(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                description = "Escolher período do aluguel",
                action = { navController.navigate(RentexScreens.ScheduleScreen.name) },
                colorApp = colorsApp[ColorApp.Red]!!
            )
        }

    }
}