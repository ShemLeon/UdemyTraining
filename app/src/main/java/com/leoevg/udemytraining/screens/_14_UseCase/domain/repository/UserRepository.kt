package com.leoevg.udemytraining.screens._14_UseCase.domain.repository

import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}