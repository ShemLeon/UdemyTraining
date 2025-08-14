package com.leoevg.udemytraining.screens._14_UseCase.domain.usecase

import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import org.w3c.dom.Text

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        if (param.name.isEmpty()) return false
        else return true
    }

}