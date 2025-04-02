package com.leoevg.udemytraining.di
// просто класс, который мы будем реализовать дагерхилтом

class SayHelloWorldManager(private val name: String) {
    fun sayHello(): String{
        return "Hello $name!"
    }
}