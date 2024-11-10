package com.example.mvvm_dagger2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger2.MyViewModel.MainViewModel
import com.example.mvvm_dagger2.repository.ProductRepository
import javax.inject.Inject

class MyViewModelFactory @Inject  constructor(private val repository: ProductRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}