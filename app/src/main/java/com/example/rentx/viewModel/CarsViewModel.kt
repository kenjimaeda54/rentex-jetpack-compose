package com.example.rentx.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentx.model.CarsModel
import com.example.rentx.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(private val repository: DatabaseRepository) : ViewModel() {
    private val _carList = MutableStateFlow<List<CarsModel>>(emptyList())
    val cartList = _carList.asStateFlow()
    val selectedCar = mutableStateOf<CarsModel?>(null)

    init {
        viewModelScope.launch {
            repository.get().distinctUntilChanged().collect {
                if (it.isEmpty()) {
                    Log.d("ListCars", "List is empty")
                } else {
                    _carList.value = it
                }
            }
        }

    }


    fun addCar(carModel: CarsModel) = viewModelScope.launch {
        repository.addCar(carModel)
    }


    fun handleSelectedCar(carModel: CarsModel) {
        selectedCar.value = carModel
    }
}