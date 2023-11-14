package com.example.rentx.view.buttonCommon

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontInter

@Composable
fun ButtonCommon(
    modifier: Modifier = Modifier,
    description: String,
    action: () -> Unit,
    colorApp: Color,
    enable: Boolean = true
) {
    Button(
        modifier = modifier,
        enabled = enable,
        onClick = { action.invoke() }, shape = RectangleShape, colors = ButtonDefaults.buttonColors(
            containerColor = colorApp
        )
    ) {
        Text(
            text = description,
            fontFamily = fontInter,
            fontWeight = FontWeight.Medium,
            color = colorsApp[ColorApp.White]!!,
            fontSize = 15.sp
        )
    }
}


@Preview
@Composable
fun ButtonCommonPreview() {
    ButtonCommon(
        description = "Escolher o periodo do aluguel",
        action = {},
        colorApp = colorsApp[ColorApp.Red]!!
    )
}