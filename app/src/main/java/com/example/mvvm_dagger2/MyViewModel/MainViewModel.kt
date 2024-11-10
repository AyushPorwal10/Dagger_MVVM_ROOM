package com.example.mvvm_dagger2.MyViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_dagger2.Product
import com.example.mvvm_dagger2.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productLiveData : LiveData<List<Product>>
        get() = repository.productLiveData


    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}