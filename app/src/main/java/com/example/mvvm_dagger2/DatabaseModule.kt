package com.example.mvvm_dagger2

import android.content.Context
import androidx.room.Room
import com.example.mvvm_dagger2.di.ApplicationComponent
import com.example.mvvm_dagger2.room.FakerDAO
import com.example.mvvm_dagger2.room.FakerDB
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    // here we need application context which we got on runtime , to get things on runtime in Dagger we make Factory

    @Singleton
    @Provides
    fun providesFakerDao(context : Context) : FakerDB{
        return Room.databaseBuilder(context , FakerDB::class.java , "FakerDB").build()
    }


}