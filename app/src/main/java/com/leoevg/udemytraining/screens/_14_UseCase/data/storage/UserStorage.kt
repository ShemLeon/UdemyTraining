package com.leoevg.udemytraining.screens._14_UseCase.data.storage

import com.leoevg.udemytraining.screens._14_UseCase.data.storage.models.User
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}