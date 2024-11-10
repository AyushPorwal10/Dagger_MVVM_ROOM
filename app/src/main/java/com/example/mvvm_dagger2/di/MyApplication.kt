package com.example.mvvm_dagger2.di

import android.app.Application
import dagger.Component

class MyApplication : Application(){
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()


        //when we define factory in component to pass runtime value .builder().build() do not work instead we use factory

        //applicationComponent = DaggerApplicationComponent.builder().build()

       applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}