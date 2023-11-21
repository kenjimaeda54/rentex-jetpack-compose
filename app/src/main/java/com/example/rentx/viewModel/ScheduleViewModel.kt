package com.example.rentx.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentx.data.DataOrException
import com.example.rentx.model.SchedulesModel
import com.example.rentx.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val repository: ApiRepository,
) : ViewModel() {
    var dataSchedulesModel: MutableState<DataOrException<SchedulesModel, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    val selectionDates = mutableStateOf(emptyList<LocalDate>())


    fun getSchedulesByCar(id: String) {
        viewModelScope.launch {
            dataSchedulesModel.value = repository.getSchedulesByCar(id)
            dataSchedulesModel.value.loading = false
        }
    }

    fun onSelectionChanged(selection: List<LocalDate>) {
        selectionDates.value = selection;
    }

    fun updateDatesUnavailableDates(carId: String,schedulesModel: SchedulesModel) {
        viewModelScope.launch {
            repository.updateSchedulesDates(carId,schedulesModel)
        }
    }




}