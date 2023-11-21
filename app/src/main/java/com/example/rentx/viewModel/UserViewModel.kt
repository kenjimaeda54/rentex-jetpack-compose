package com.example.rentx.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentx.data.DataOrException
import com.example.rentx.model.ScheduleCarByUserModel
import com.example.rentx.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val tokenCacheViewModel: UserCacheViewModel
) :
    ViewModel() {
    var token = mutableStateOf("")
    var dataSchedulesCarByUser: MutableState<DataOrException<ScheduleCarByUserModel, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )


    init {
        val tokenCache = tokenCacheViewModel.getToken()
        if (tokenCache != null) {
            handleGetScheduleCarsByUser(tokenCache)
            token.value = tokenCache
        } else {
            val newToken = UUID.randomUUID().toString()
            handleGetScheduleCarsByUser(newToken)
            tokenCacheViewModel.saveToken(newToken)
            token.value = newToken
        }
    }


    private fun handleGetScheduleCarsByUser(token: String) {
        viewModelScope.launch {
            dataSchedulesCarByUser.value =
                repository.getScheduleByUser(token)
            dataSchedulesCarByUser.value.loading = false
        }
    }

    fun updateSchedulesCarByUser(
        schedulesCarByUserModel: ScheduleCarByUserModel
    ) {
        viewModelScope.launch {
            repository.updateScheduleCarByUser(token.value, schedulesCarByUserModel)
        }
    }

    fun createScheduleCarByUser(schedulesCarByUserModel: ScheduleCarByUserModel) {
        viewModelScope.launch {
            repository.createScheduleByUser(schedulesCarByUserModel)
        }
    }


}