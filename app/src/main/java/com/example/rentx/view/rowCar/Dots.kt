package com.example.rentx.view.rowCar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp

@Composable
fun Dots(colorApp: Color,modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(6.dp)) {
        drawCircle(
            color = colorApp
        )
    }
}