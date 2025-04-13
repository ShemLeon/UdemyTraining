package com.leoevg.udemytraining.data
import javax.inject.Inject

// конструктор будет принимать в себя объект класса UserManager
class SayByeByeManager @Inject constructor(
    private val userManager: UserManager
) {
    fun sayBye(): String{
        return "Bye Bye ${userManager.name} ${userManager.surname}, " +
                "id: ${userManager.id}!"
    }
}