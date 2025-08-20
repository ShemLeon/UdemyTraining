package com.leoevg.udemytraining.screens._14_UseCase.domain.usecase

import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}


//