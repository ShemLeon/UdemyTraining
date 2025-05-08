package com.leoevg.udemytraining.viewmodels

import androidx.lifecycle.ViewModel
import com.leoevg.udemytraining.data.SayByeByeManager
import com.leoevg.udemytraining.data.SayHelloWorldManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class _5_DaggerExampleViewModel @Inject constructor(
    private val sayHelloWorldManager: SayHelloWorldManager,
    private val sayByeByeManager: SayByeByeManager
) : ViewModel() {
    
    fun sayHello(): String {
        return sayHelloWorldManager.sayHello()
    }
    fun sayBye(): String {
        return sayByeByeManager.sayBye()
    }
} 