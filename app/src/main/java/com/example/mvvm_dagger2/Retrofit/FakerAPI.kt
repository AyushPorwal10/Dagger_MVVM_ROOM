package com.example.mvvm_dagger2.Retrofit

import com.example.mvvm_dagger2.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
   suspend fun getProducts() : Response<List<Product>>
}