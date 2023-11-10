package com.example.rentx.di

import android.content.Context
import androidx.room.Room
import com.example.rentx.data.RentexDao
import com.example.rentx.data.RentexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun rentexDatabase(@ApplicationContext context: Context): RentexDatabase = Room.databaseBuilder(
        context,
        RentexDatabase::class.java,
        "rentex_db"
    ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun rentexDatabaseDao(rentexDatabase: RentexDatabase): RentexDao = rentexDatabase.RentexDao()

}