package com.leoevg.udemytraining.screens._6_ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leoevg.udemytraining.navigation.NavigationPath

class _6_ScreenExampleViewModel : ViewModel(){
    var email by mutableStateOf("email@gmail.com")
    var password by mutableStateOf("")
    var error by mutableStateOf<String?>(null)
    var navigateTo by mutableStateOf<NavigationPath?>(null)

    fun login(){
        //  if (email.isEmpty()){        }
        if (email == "email@gmail.com" && password == "1234"){
            // error = null
            navigateTo = NavigationPath.StartSealed
        }
        else
            error = "Error logging on"
    }
}