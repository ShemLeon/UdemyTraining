package com.leoevg.udemytraining.navigation
import kotlinx.serialization.Serializable

sealed interface NavigationPath{
    @Serializable object StartSealed: NavigationPath
    @Serializable object HelloWorldSealed: NavigationPath
    @Serializable object GreetingAppSealed: NavigationPath
    @Serializable object CurConverterSealed: NavigationPath
    @Serializable object FragmentAppSealed: NavigationPath
    @Serializable object ExampleDaggerSealed: NavigationPath
    @Serializable object ExampleViewModelSealed: NavigationPath
    @Serializable object ExampleLazyRowSealed: NavigationPath
    @Serializable object ExampleCustomComponentSealed: NavigationPath
    @Serializable object ExampleActivityLifeCycleSealed: NavigationPath
    @Serializable object ExampleSnackBar: NavigationPath
    @Serializable object ExampleRetroFit: NavigationPath
    @Serializable object ExampleRetrofitAuth: NavigationPath
    @Serializable object ExampleRetrofitListSealed: NavigationPath
    @Serializable object ExampleExperimentsSealed: NavigationPath

}