package com.example.mvvm_dagger2.di

import com.example.mvvm_dagger2.Constants
import com.example.mvvm_dagger2.Retrofit.FakerAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton      // this make sure that only one obj is created throughout application
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    @Singleton
    @Provides          
    fun providesFakerAPI(retrofit: Retrofit) : FakerAPI{
        return retrofit.create(FakerAPI::class.java)
    }
}