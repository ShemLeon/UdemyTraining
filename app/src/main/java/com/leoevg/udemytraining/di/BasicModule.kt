package com.leoevg.udemytraining.di

import com.leoevg.udemytraining.data.SayByeByeManager
import com.leoevg.udemytraining.data.SayHelloWorldManager
import com.leoevg.udemytraining.data.UserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.UUID
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasicModule {
    @Provides
    fun provideNameManager(): UserManager {
        return UserManager(UUID.randomUUID().toString(), "App", "userovich")
    }

    @Provides
    @Singleton
    fun provideSayByeByeManager(userManager: UserManager): SayByeByeManager {
        return SayByeByeManager(userManager)
    }

    @Provides
    @Singleton
    fun provideSayHelloWorldManager(userManager: UserManager): SayHelloWorldManager {
        return SayHelloWorldManager("userManager")
    }

}


// практическое применение - в какой-то момент в приложении может быть запрошен
// объект типа SayHelloWorldManager я использую функцию providerSHWManager -
// чтобы получить из нее этот объект и его туда запушить

// Это структура, в которой я обьявлю для Dagger Hilt
// функции-"провайдер", которые умеют билдить объекты
// @InstallIn - аннотация, чтобы DH понял, куда сохранить объект
// Singleton - говорит о том, что этот модуль будет создан в начале приложения
// и сохранен на весь участок работы приложухи.
// Можно привязать только к активности

// ::  - это ссылка на класс

