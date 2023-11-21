package com.example.rentx.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.rentx.utility.UserCache
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserCacheViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ViewModel(), UserCache {

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString("tokenUser", token).apply()
    }

    override fun getToken(): String? {
        return sharedPreferences.getString("tokenUser", null);
    }
}