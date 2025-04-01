package com.leoevg.udemytraining.navigation
import kotlinx.serialization.Serializable

sealed interface NavigationPath{
    @Serializable object StartNazvanie: NavigationPath
    @Serializable object HelloWorldNazvanie: NavigationPath
    @Serializable object GreetingAppNazvanie: NavigationPath
    @Serializable object CurConverterNazvanie: NavigationPath

}