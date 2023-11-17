package com.example.rentx.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentx.data.DataOrException
import com.example.rentx.model.Schedules
import com.example.rentx.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.boguszpawlowski.composecalendar.CalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    var dataSchedules: MutableState<DataOrException<Schedules, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    val selectionDates = mutableStateOf(emptyList<LocalDate>())
    fun getSchedulesByCar(id: String) {
        viewModelScope.launch {
            dataSchedules.value = repository.getSchedulesByCar(id)
            dataSchedules.value.loading = false
        }
    }

    fun onSelectionChanged(selection: List<LocalDate>) {
        selectionDates.value = selection;
    }
}