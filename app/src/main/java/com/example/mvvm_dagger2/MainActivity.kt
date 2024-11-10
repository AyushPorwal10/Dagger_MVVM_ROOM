package com.example.mvvm_dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger2.MyViewModel.MainViewModel
import com.example.mvvm_dagger2.di.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val product : TextView
        get() = findViewById(R.id.products)

    @Inject  // we need to tell Dagger that we use @Inject here so we will use component below
    lateinit var mainViewModelFactory: MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // as this is passed to component , component will check all the field annotate with @Inject

        (application as MyApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this , mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this , Observer {
            product.text = it.joinToString { x->x.title + "\n\n" }
        })
    }
}