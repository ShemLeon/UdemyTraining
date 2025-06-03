package com.leoevg.udemytraining.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoevg.udemytraining.screens.CurConverter
import com.leoevg.udemytraining.screens.ExampleActivityLifeCycle
import com.leoevg.udemytraining.screens.ExampleCustomComponent
import com.leoevg.udemytraining.screens.ExampleDaggerHilt
import com.leoevg.udemytraining.screens.ExampleLazyRow
import com.leoevg.udemytraining.screens.ExampleViewModel
import com.leoevg.udemytraining.screens.FragmentApp
import com.leoevg.udemytraining.screens.GreetingApp
import com.leoevg.udemytraining.screens.HelloWorld
import com.leoevg.udemytraining.screens.StartScreen

@Composable
fun MainNavHost(){
    val navController = rememberNavController()
    val context = LocalContext.current

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
            ExampleDaggerHilt(
                navigate = { path ->
                    navController.navigate(path)
                }
            )
        }
        composable<NavigationPath.ExampleViewModelSealed> {
            ExampleViewModel{ path ->
                    navController.navigate(path)
            }
        }
        composable<NavigationPath.ExampleLazyRowSealed> {
            ExampleLazyRow{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.ExampleCustomComponentSealed> {
            ExampleCustomComponent{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.ExampleActivityLifeCycleSealed> {
            ExampleActivityLifeCycle(navigate = { path ->
                navController.navigate(path)
            })
        }




    }
}