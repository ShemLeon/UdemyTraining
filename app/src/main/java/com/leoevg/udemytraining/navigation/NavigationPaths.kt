package com.leoevg.udemytraining.navigation
import kotlinx.serialization.Serializable

sealed interface NavigationPath{
    @Serializable object StartNazvanie: NavigationPath
    @Serializable object HelloWorldNazvanie: NavigationPath
    @Serializable object GreetingAppNazvanie: NavigationPath
    @Serializable object CurConverterNazvanie: NavigationPath
    @Serializable object FragmentAppNazvanie: NavigationPath
    @Serializable object ExampleDaggerNazvanie: NavigationPath
    @Serializable object ExampleViewModelNazvanie: NavigationPath
}