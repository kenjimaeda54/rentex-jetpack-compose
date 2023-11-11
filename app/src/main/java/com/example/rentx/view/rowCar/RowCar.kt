package com.example.rentx.view.rowCar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rentx.model.CarsModel
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.utils.returnSvgIcon

@Composable
fun RowCar(carsModel: CarsModel) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 21.dp)
            .fillMaxWidth()
            .height(126.dp)
            .background(colorsApp[ColorApp.White]!!, shape = RoundedCornerShape(3.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 21.dp, vertical = 21.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = carsModel.brand,
                    fontFamily = fontArchivo,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorsApp[ColorApp.Gray100]!!
                )
                Text(
                    text = carsModel.name, fontFamily = fontArchivo,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = colorsApp[ColorApp.Black100]!!
                )
            }
            Spacer(modifier = Modifier.height(14.dp))

            Column {
                Text(
                    text = carsModel.rentModel.period, fontFamily = fontArchivo,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = colorsApp[ColorApp.Gray100]!!
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "R$ ${carsModel.rentModel.price}", fontFamily = fontArchivo,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = colorsApp[ColorApp.Red]!!
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = returnSvgIcon(carsModel.fuelType)),
                        contentDescription = "Icone tipo de motor"
                    )
                }

            }


        }
        AsyncImage(
            modifier = Modifier
                .height(92.dp)
                .width(160.dp),
            model = ImageRequest.Builder(LocalContext.current).data(carsModel.thumbnail).build(),
            alignment = Alignment.BottomCenter,
            contentDescription = "Image row cars",
            contentScale = ContentScale.Fit
        )

    }
}