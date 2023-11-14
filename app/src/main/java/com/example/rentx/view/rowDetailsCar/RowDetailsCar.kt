package com.example.rentx.view.rowDetailsCar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontInter

@Composable
fun RowDetailsCar(idPainter: Int, description: String) {
    Surface(
        modifier = Modifier
            .width(90.dp)
            .padding(vertical = 7.dp),
        color = colorsApp[ColorApp.Gray200]!!.copy(0.1f)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = idPainter),
                contentDescription = "Image row description",
                colorFilter = ColorFilter.tint(colorsApp[ColorApp.Black100]!!)
            )
            Text(
                text = description,
                fontFamily = fontInter,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                color = colorsApp[ColorApp.Gray200]!!
            )
        }

    }


}