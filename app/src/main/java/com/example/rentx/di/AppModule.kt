package com.example.rentx.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.rentx.service.RentexServiceApi
import com.example.rentx.utility.Constants
import com.example.rentx.viewModel.UserCacheViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun rentexServiceApi(): RentexServiceApi = Retrofit.Builder().baseUrl(Constants.baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(RentexServiceApi::class.java)

    @Singleton
    @Provides
    fun rentexSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("session_prefs", MODE_PRIVATE)

    @Singleton
    @Provides
    fun rentexTokenCache(sharedPreferences: SharedPreferences): UserCacheViewModel =
        UserCacheViewModel(sharedPreferences)

}