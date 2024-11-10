package com.example.mvvm_dagger2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_dagger2.Product

@Dao
interface FakerDAO {

    @Insert
    suspend fun addProducts(product: List<Product>)

    @Query("Select * from Product")
    suspend fun getProducts() : List<Product>
}