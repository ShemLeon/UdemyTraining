package com.leoevg.udemytraining.data

import javax.inject.Inject

// конструктор будет принимать в себя объект класса NameManager
class SayByeByeManager @Inject constructor(
    private val nameManager: NameManager
) {
    fun sayBye(): String{
        return "Bye Bye ${nameManager.name} ${nameManager.surname}!"
    }
}