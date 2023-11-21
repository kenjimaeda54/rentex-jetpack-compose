package com.example.rentx.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentx.data.DataOrException
import com.example.rentx.model.CarsModel
import com.example.rentx.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    var dataCars: MutableState<DataOrException<List<CarsModel>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    var selectedCar = mutableStateOf<CarsModel?>(null)


    fun getAllCar() {
        viewModelScope.launch {
            dataCars.value = repository.getCars()
            dataCars.value.loading = false
        }
    }


    fun handleSelectedCar(carModel: CarsModel) {
        selectedCar.value = carModel
    }




}