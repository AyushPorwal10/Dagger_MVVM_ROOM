package com.example.mvvm_dagger2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_dagger2.Product
import com.example.mvvm_dagger2.Retrofit.FakerAPI
import com.example.mvvm_dagger2.room.FakerDB
import javax.inject.Inject


// we will get object of faker api and it is given by Dagger , Dagger check if its implementation is available or not
// it is available in Network Module
class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI , private val fakerDB: FakerDB) {

    private val mutableLiveData = MutableLiveData<List<Product>>()

     val productLiveData : LiveData<List<Product>>
        get() = mutableLiveData
    suspend fun getProduct(){
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            fakerDB.getFakerDao().addProducts(result.body()!!)
            mutableLiveData.postValue(result.body())
        }

    }
}