package com.leoevg.udemytraining.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// это какая-то структура, в которой я обьявлю для Dagger Hilt
// Как правило это функции-"провайдеры", которые умеют билдить объекты
// @InstallIn - аннотация, чтобы DH понял, куда сохранить объект

@Module
@InstallIn(SingletonComponent::class)
object BasicModule {

}