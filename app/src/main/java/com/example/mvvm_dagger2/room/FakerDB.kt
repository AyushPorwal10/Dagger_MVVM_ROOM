package com.example.mvvm_dagger2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_dagger2.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB  : RoomDatabase(){

    abstract fun getFakerDao() : FakerDAO
}