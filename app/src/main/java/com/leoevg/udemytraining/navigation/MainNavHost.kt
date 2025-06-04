package com.leoevg.udemytraining.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoevg.udemytraining.screens.CurConverter
import com.leoevg.udemytraining.screens._9_ActivityLifeCycle.ExampleActivityLifeCycle
import com.leoevg.udemytraining.screens.ExampleCustomComponent
import com.leoevg.udemytraining.screens.ExampleDaggerHilt
import com.leoevg.udemytraining.screens.ExampleLazyRow
import com.leoevg.udemytraining.screens._10_Snackbar.ExampleSnackBar
import com.leoevg.udemytraining.screens.ExampleViewModel
import com.leoevg.udemytraining.screens.FragmentApp
import com.leoevg.udemytraining.screens.GreetingApp
import com.leoevg.udemytraining.screens.HelloWorld
import com.leoevg.udemytraining.screens.StartScreen

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




    }
}