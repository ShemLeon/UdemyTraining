package com.leoevg.udemytraining.data
// класс, который нужно реализовать дагерхилтом
import javax.inject.Inject

class SayHelloWorldManager @Inject constructor(
    private val name: String
) {
    fun sayHello(): String{
        return "Hello $name!"
    }
}