package com.leoevg.udemytraining.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoevg.udemytraining.screens.CurConverter
import com.leoevg.udemytraining.screens._9_ActivityLifeCycle.ExampleActivityLifeCycle
import com.leoevg.udemytraining.screens.ExampleCustomComponent
import com.leoevg.udemytraining.screens._5_DaggerHilt.ExampleDaggerHilt
import com.leoevg.udemytraining.screens.ExampleLazyRow
import com.leoevg.udemytraining.screens._10_Snackbar_fromFilipLackner.ExampleSnackBar
import com.leoevg.udemytraining.screens.ExampleViewModel
import com.leoevg.udemytraining.screens.FragmentApp
import com.leoevg.udemytraining.screens.GreetingApp
import com.leoevg.udemytraining.screens._1_HelloWorld_SnackBar.HelloWorld
import com.leoevg.udemytraining.screens.StartScreen
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.ExampleRetroFit
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.ExampleRetrofitAuth
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.ExampleRetrofitList
import com.leoevg.udemytraining.screens._12_Experiments.ExperimentsScreen
import com.leoevg.udemytraining.screens._13_Room.RoomScreen


@Composable
fun MainNavHost(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationPath.StartSealed
    ) {
        composable<NavigationPath.StartSealed> {
            StartScreen { path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.HelloWorldSealed> {
            HelloWorld()
        }
        composable<NavigationPath.GreetingAppSealed> {
            GreetingApp{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.CurConverterSealed> {
            CurConverter{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.FragmentAppSealed> {
            FragmentApp{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.ExampleDaggerSealed> {
            ExampleDaggerHilt(navigate ={
                navController.navigate(it)
            })
        }
        composable<NavigationPath.ExampleViewModelSealed> {
            ExampleViewModel(navigate ={
                navController.navigate(it)
            })
        }
        composable<NavigationPath.ExampleLazyRowSealed> {
            ExampleLazyRow(navigate ={
                navController.navigate(it)
            })
        }
        composable<NavigationPath.ExampleCustomComponentSealed> {
            ExampleCustomComponent(navigate ={
                navController.navigate(it)
            })
        }
        composable<NavigationPath.ExampleActivityLifeCycleSealed> {
            ExampleActivityLifeCycle(navigate = {
                navController.navigate(it)
            })
        }

//        navigate = {
//            navController.navigate(it)
//        },
//        popBackStack = {
//            navController.popBackStack()
//        }

        composable<NavigationPath.ExampleSnackBar> {
            ExampleSnackBar(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable<NavigationPath.ExampleRetroFit> {
            ExampleRetroFit(navigate = {
                navController.navigate(it)
            })
        }

        composable<NavigationPath.ExampleRetrofitAuth> {
            ExampleRetrofitAuth(navigate = {
                navController.navigate(it)
            })
        }

        composable<NavigationPath.ExampleRetrofitListSealed> {
            ExampleRetrofitList(navigate = {
                navController.navigate(it)
            })
        }

        composable<NavigationPath.ExampleExperimentsSealed> {
            ExperimentsScreen(navigate = {
                navController.navigate(it)
            })
        }

        composable<NavigationPath.ExampleRoomSealed> {
            RoomScreen(navigate = {
                navController.navigate(it)
            })
        }




    }
}