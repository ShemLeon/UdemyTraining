package com.leoevg.udemytraining.screens._14_UseCase.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leoevg.udemytraining.screens._14_UseCase.data.repository.UserRepositoryImpl
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.usecase.GetUserNameUseCase
import com.leoevg.udemytraining.screens._14_UseCase.domain.usecase.SaveUserNameUseCase


class UseCaseViewModel : ViewModel() {
    // состояния для хранения текста
    var displayText by mutableStateOf("")
    var inputText by mutableStateOf("")

    // создание репозитория
    private val userRepository = UserRepositoryImpl()
    // создание UseCase'ов
    private val getUserNameUseCase = GetUserNameUseCase(userRepository = userRepository)
    private val saveUserNameUseCase = SaveUserNameUseCase(userRepository = userRepository)

    fun getUserName() {
        val userName = getUserNameUseCase.execute(param = SaveUserNameParam(""))
        displayText = "${userName.firstName} ${userName.lastName}"
    }
    fun saveUserName() {
        val params = SaveUserNameParam(name = inputText)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        displayText = "Save result = $result"
    }
}
