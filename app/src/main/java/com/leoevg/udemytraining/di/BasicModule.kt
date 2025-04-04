package com.leoevg.udemytraining.di

import com.leoevg.udemytraining.data.SayHelloWorldManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasicModule {
    @Provides
    @Singleton
    fun providerSHWManager(): SayHelloWorldManager {
        return SayHelloWorldManager("AppUser")
    }
}


// практическое применение - в какой то момент в приложении может быть запрошен
// объект типа SayHelloWorldManager я использую функцию providerSHWManager -
// чтобы получить из нее этот объект и его туда запушить

// Это структура, в которой я обьявлю для Dagger Hilt
// функции-"провайдер", которые умеют билдить объекты
// @InstallIn - аннотация, чтобы DH понял, куда сохранить объект
// Singleton - говорит о том, что этот модуль будет создан в начале приложения
// и сохранен на весь участок работы приложухи. можно привязать только к активности

// ::  - это ссылка на класс

