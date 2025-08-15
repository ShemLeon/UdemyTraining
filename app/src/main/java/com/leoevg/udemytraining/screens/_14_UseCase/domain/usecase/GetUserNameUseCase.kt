package com.leoevg.udemytraining.screens._14_UseCase.domain.usecase

import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName

class GetUserNameUseCase {
    fun execute(param: SaveUserNameParam): UserName{
        return UserName(
            firstName = "Leo",
            lastName = "Shemiakin"
        )
    }
}


// У нас есть UseCase в котором есть метод execute()
// который возвращает данные

