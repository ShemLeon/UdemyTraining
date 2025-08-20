package com.leoevg.udemytraining.screens._14_UseCase.domain.usecase

import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName
import com.leoevg.udemytraining.screens._14_UseCase.domain.repository.UserRepository

class GetUserNameUseCase(private val  userRepository: UserRepository) {
    fun execute(): UserName{
        return userRepository.getName()
    }
}


// У нас есть UseCase в котором есть метод execute()
// который возвращает данные

