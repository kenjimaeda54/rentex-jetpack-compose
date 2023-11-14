package com.example.rentx.screen.rentCar

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rentx.R
import com.example.rentx.ui.theme.ColorApp
import com.example.rentx.ui.theme.colorsApp
import com.example.rentx.ui.theme.fontArchivo
import com.example.rentx.ui.theme.fontInter
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.kotlinxDateTime.toKotlinYearMonth
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.text.Format
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale


//maneria de trabalhar com traducao
//https://phrase.com/blog/posts/internationalizing-jetpack-compose-android-apps/

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(navController: NavController) {
    val calendarState = rememberSelectableCalendarState(
        initialMonth = YearMonth.now(),
        selectionState = DynamicSelectionState(
            selectionMode = SelectionMode.Period,
            selection = listOf(),
        )
    )
    val selectionDates by remember {
        mutableStateOf<List<LocalDate>>(emptyList())
    }
    val localBrazil = Locale("pt", "BR")
    val formatMonthYear = DateTimeFormatter.ofPattern("MMMM yyyy", localBrazil)


    fun handleClickableDate(selectionDate: LocalDate) {
        calendarState.selectionState.onDateSelected(selectionDate)
    }

    fun handleBackgroundColorDateSelected(date: LocalDate): Color {
        val lastDate =
            calendarState.selectionState.selection[calendarState.selectionState.selection.size - 1]
        val firstDate = calendarState.selectionState.selection[0]
        if (lastDate == date || firstDate == date) {
            return colorsApp[ColorApp.Red]!!
        } else if (calendarState.selectionState.isDateSelected(date)) {
            return colorsApp[ColorApp.Red]!!.copy(0.3f)
        }
        return Color.Transparent
    }

    fun handleTextColorDateSelected(date: LocalDate): Color {
        val lastDate =
            calendarState.selectionState.selection[calendarState.selectionState.selection.size - 1]
        val firstDate = calendarState.selectionState.selection[0]
        if (lastDate == date || firstDate == date) {
            return colorsApp[ColorApp.White]!!
        }
        return colorsApp[ColorApp.Black200]!!
    }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Surface(
            Modifier
                .height(325.dp)
                .fillMaxWidth(), color = colorsApp[ColorApp.Black100]!!
        ) {
            Column(
                modifier = Modifier.padding(
                    end = 13.dp,
                    start = 13.dp,
                    top = 10.dp,
                    bottom = 20.dp
                ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    },
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Image icon back",
                    colorFilter = ColorFilter.tint(colorsApp[ColorApp.White]!!)
                )
                Text(
                    text = "Escolha uma\n" +
                            "data de início e\n" +
                            "fim do aluguel",
                    fontFamily = fontArchivo,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 34.sp

                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "DE",
                            fontFamily = fontArchivo,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = colorsApp[ColorApp.Gray200]!!
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .height(1.dp),
                            thickness = 0.5.dp,
                            color = colorsApp[ColorApp.Gray200]!!
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.arrow_large),
                        contentDescription = "Arrow from to until"
                    )
                    Column {
                        Text(
                            text = "ATE",
                            fontFamily = fontArchivo,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = colorsApp[ColorApp.Gray200]!!
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(1.dp),
                            thickness = 0.5.dp,
                            color = colorsApp[ColorApp.Gray200]!!
                        )
                    }
                }
            }


        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Surface(modifier = Modifier.padding(vertical = 30.dp, horizontal = 9.dp)) {
                SelectableCalendar(
                    calendarState = calendarState,
                    daysOfWeekHeader = { dayOfWeeks ->
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                dayOfWeeks.forEach { dayOfWeek ->
                                    Text(
                                        text = dayOfWeek.getDisplayName(
                                            TextStyle.SHORT,
                                            localBrazil
                                        )
                                            .replace(".", "").uppercase(),
                                        fontFamily = fontArchivo,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorsApp[ColorApp.Gray100]!!
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Divider(thickness = 0.5.dp)
                            Spacer(modifier = Modifier.height(15.dp))
                        }

                    },
                    dayContent = { dayState ->
                        if (dayState.date.dayOfWeek == DayOfWeek.SUNDAY || dayState.date.dayOfWeek == DayOfWeek.SATURDAY || !dayState.isFromCurrentMonth ||
                            (dayState.date.isBefore(LocalDate.now()))
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp),
                                text = dayState.date.dayOfMonth.toString(),
                                fontFamily = fontInter,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorsApp[ColorApp.Gray100]!!.copy(0.3f),
                                textAlign = TextAlign.Center
                            )
                        } else {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp)
                                    .clickable(
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() }
                                    ) {
                                        handleClickableDate(dayState.date)
                                    }
                                    .background(
                                        if (calendarState.selectionState.selection.isEmpty()) Color.Transparent else handleBackgroundColorDateSelected(
                                            dayState.date
                                        ),
                                        RectangleShape
                                    ),
                                text = dayState.date.dayOfMonth.toString(),
                                fontFamily = fontInter,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                color = if (calendarState.selectionState.selection.isEmpty()) colorsApp[ColorApp.Black200]!! else handleTextColorDateSelected(
                                    dayState.date
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    },
                    monthHeader = { monthState ->
                        if (monthState.currentMonth == YearMonth.now()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.weight(2.0f))
                                Text(
                                    text = monthState.currentMonth.format(formatMonthYear)
                                        .replaceFirstChar { char ->
                                            if (char.isLowerCase()) char.titlecase() else char.toString()
                                        },
                                    fontFamily = fontArchivo,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colorsApp[ColorApp.Black100]!!

                                )
                                Spacer(modifier = Modifier.weight(1.1f))
                                IconButton(
                                    onClick = {
                                        monthState.currentMonth =
                                            monthState.currentMonth.plusMonths(1)
                                    }) {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = "Icon",
                                        colorFilter = ColorFilter.tint(color = colorsApp[ColorApp.Black100]!!)
                                    )
                                }
                            }

                        } else if (monthState.currentMonth > YearMonth.now()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = {
                                    monthState.currentMonth = monthState.currentMonth.minusMonths(1)

                                }) {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = Icons.Default.KeyboardArrowLeft,
                                        contentDescription = "Icon",
                                        colorFilter = ColorFilter.tint(color = colorsApp[ColorApp.Black100]!!)
                                    )
                                }
                                Text(
                                    text = monthState.currentMonth.format(formatMonthYear)
                                        .replaceFirstChar { char ->
                                            if (char.isLowerCase()) char.titlecase() else char.toString()
                                        },
                                    fontFamily = fontArchivo,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colorsApp[ColorApp.Black100]!!
                                )
                                IconButton(onClick = {
                                    monthState.currentMonth = monthState.currentMonth.plusMonths(1)
                                }) {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = "Icon",
                                        colorFilter = ColorFilter.tint(color = colorsApp[ColorApp.Black100]!!)
                                    )
                                }
                            }

                        }
                    }
                )
            }

        }
    }

}


