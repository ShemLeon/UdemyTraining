package com.leoevg.udemytraining.viewmodels

import androidx.lifecycle.ViewModel
import com.leoevg.udemytraining.data.SayHelloWorldManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DaggerExampleViewModel @Inject constructor(
    private val sayHelloWorldManager: SayHelloWorldManager
) : ViewModel() {
    
    fun sayHello(): String {
        return sayHelloWorldManager.sayHello()
    }
} 