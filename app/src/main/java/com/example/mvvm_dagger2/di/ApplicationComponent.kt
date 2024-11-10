package com.example.mvvm_dagger2.di

import android.content.Context
import com.example.mvvm_dagger2.DatabaseModule
import com.example.mvvm_dagger2.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


// we will define this component at application level because it have some object that are singleton in full application

@Singleton  // we  use this because in below module we have object that are scoped
@Component(modules = [NetworkModule::class , DatabaseModule::class])
interface ApplicationComponent  {

    // here we are using field injection , we will annotate some field of main activity with @inject ,
    // dagger will check fields with @inject and initialize them
    fun inject(mainActivity: MainActivity)



    // here we are binding context inside component
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context : Context) : ApplicationComponent
    }
}