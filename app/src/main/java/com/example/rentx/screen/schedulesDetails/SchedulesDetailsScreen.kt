package com.example.rentx.screen.schedulesDetails

import android.icu.util.Currency
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rentx.R
import com.example.rentx.route.RentexScreens
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import com.example.rentx.utility.formatDateTime
import com.example.rentx.utility.returnSvgIcon
import com.example.rentx.view.buttonCommon.ButtonCommon
import com.example.rentx.view.rowCar.Dots
import com.example.rentx.view.rowDetailsCar.RowDetailsCar
import com.example.rentx.viewModel.CarsViewModel
import com.example.rentx.viewModel.ScheduleViewModel
import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SchedulesDetailsScreen(
    parentCarViewModel: CarsViewModel,
    navController: NavController,
    parentScheduleViewModel: ScheduleViewModel
) {
    var indexSelected by remember {
        mutableIntStateOf(0)
    }
    val photoCar by remember(indexSelected) {
        mutableStateOf(parentCarViewModel.selectedCar.value?.photos?.get(indexSelected))
    }
    val localBrazil = Locale("pt", "BR")
    val numberFormat = NumberFormat.getCurrencyInstance(localBrazil)
    val totalPrice = parentCarViewModel.selectedCar.value?.rent?.price?.times(
        parentScheduleViewModel.selectionDates.value.size
    )
    val currency = numberFormat.format(totalPrice)


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
                parentCarViewModel.selectedCar.value?.photos?.forEachIndexed { index, _ ->
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
                parentCarViewModel.selectedCar.value?.let {
                    Text(
                        text = it.brand,
                        fontFamily = fontArchivo,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Gray100]!!
                    )
                }
                parentCarViewModel.selectedCar.value?.let {

                    Text(
                        text = it.name, fontFamily = fontArchivo,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Black100]!!
                    )
                }
            }
            Column {
                parentCarViewModel.selectedCar.value?.let {
                    Text(
                        text = it.rent.period, fontFamily = fontArchivo,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorsApp[ColorApp.Gray100]!!
                    )
                }
                parentCarViewModel.selectedCar.value?.let {
                    Text(
                        text = "R$ ${it.rent.price}", fontFamily = fontArchivo,
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
            parentCarViewModel.selectedCar.value?.let {
                items(it.accessories) { accessory ->
                    RowDetailsCar(
                        idPainter = returnSvgIcon(accessory.type),
                        description = accessory.name
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = "Icon calendar"
            )
            Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                Text(
                    text = "DE",
                    fontFamily = fontArchivo,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorsApp[ColorApp.Gray200]!!
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = formatDateTime(parentScheduleViewModel.selectionDates.value[0]),
                    fontFamily = fontInter,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorsApp[ColorApp.Black200]!!
                )
            }

            Image(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow separated date",
                colorFilter = ColorFilter.tint(colorsApp[ColorApp.Gray200]!!)
            )

            Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                Text(
                    text = "ATÉ",
                    fontFamily = fontArchivo,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorsApp[ColorApp.Gray200]!!
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = formatDateTime(parentScheduleViewModel.selectionDates.value[parentScheduleViewModel.selectionDates.value.size - 1]),
                    fontFamily = fontInter,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorsApp[ColorApp.Black200]!!
                )
            }


        }
        Divider(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 11.dp),
            color = colorsApp[ColorApp.Gray100]!!,
            thickness = 0.5.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "TOTAL",
                    fontFamily = fontArchivo,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorsApp[ColorApp.Gray200]!!
                )
                Text(
                    text = "R$ ${parentCarViewModel.selectedCar.value?.rent?.price} x ${parentScheduleViewModel.selectionDates.value.size}",
                    fontFamily = fontInter,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorsApp[ColorApp.Black200]!!
                )
            }

            Text(
                text = currency,
                fontFamily = fontArchivo,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                color = colorsApp[ColorApp.Green]!!
            )
        }

        Surface(
            modifier = Modifier
                .height(111.dp)
                .padding(top = 19.dp),
            color = colorsApp[ColorApp.Gray100]!!.copy(0.3f)
        ) {
            ButtonCommon(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                description = "Alugar agora",
                action = { navController.navigate(RentexScreens.ScheduleScreen.name) },
                colorApp = colorsApp[ColorApp.Green]!!
            )
        }


    }
}