package com.leoevg.udemytraining.screens._14_UseCase.data.repository

import android.content.Context
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName
import com.leoevg.udemytraining.screens._14_UseCase.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"

class UserRepositoryImpl(private val context: Context): UserRepository {
    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, saveParam.name).apply()

        return true
    }

    override fun getName(): UserName {
        return UserName(
            firstName = "Leo",
            lastName = "Hello from Repository"
        )
    }
}