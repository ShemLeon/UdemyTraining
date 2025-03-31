package com.leoevg.udemytraining.screens

import androidx.core.app.NotificationCompat.MessagingStyle.Message

fun main(){
    // Variables:
        // 1. Mutable variable
        var age: Int = 15
        var mage = 2
        // 2. Immutable variable
    val pi: Double = 3.14

    // Data types
        // 1. Byte: -128 to 127
    val bit: Byte = 5
        // 2. Short: -32786 to 32767
    val short: Short = 5000
        // 3. Int: -2million to 2 million
    val myInt: Int = 5000
        // 4. Long: -** to +**
    val long: Long = 50010000
        // 5. Float: decimals 0.000
    val myFloat: Float = 50.0120f
        // 6. Double: decimals 0.000
    val double: Double = 50.012000
        //7. Boolean: true or false
    val isRain: Boolean = true
    if (!isRain) println("rain")
        // 8. Characters (letter, Digit, Special chars)
    val char: Char = 'A'
        // 9. Strings
    val myString: String = "Hello friends"
    println(myString)
        // Concatenation
    println("Age = "+age)
    println("result of ${myInt} and ${myFloat} = ${myInt+myFloat}")

    // When expression
    val day = 3
    when(day){
        1 -> println("Monday")
        2 -> println("Thursday")
        3 -> println("Yom shlishi")
        else -> println("Unknown")
    }

    // Array - collection of elements of the same data type
    val osNames = arrayOf("Windows", "Android", "Linux")
    println(osNames[0])
    osNames[1] = "IOS"
    val sizeArr = osNames.size

    // Loops
        // 1. Range
    for(i in 1..5)
        print(i)
        // 2. Foreach
    for (name in osNames)
        println(name)
        // 3. Lambda
    osNames.forEach { name -> println(name) }

    // Functions
    /*
    fun sayHello(name: String, age: String = "Not Specified"){
        println("Hello $name, your age is $age")
}
    */
    sayHello("Jack")
    sayHello("Jack", "5")
    var res1 = sumNumb(5,4)
    var res2 = sumNumb(5.2,4.0)

    // OOP
    val robot1 = Robot("Transformer")
    robot1.walk()
    robot1.speak("Trah babah")



}

fun sayHello(name: String, age: String = "Not Specified"){
    println("Hello $name, your age is $age")
}
fun sumNumb(x: Int, y: Int):Int{
    return x+y
}
fun sumNumb(x: Double, y: Double):Double{
    return x+y
}

class Robot(val name: String){
    fun walk(){
        println("The Robot is Walking now")
    }
    fun speak(message: String){
        println("$name says $message")
    }
}