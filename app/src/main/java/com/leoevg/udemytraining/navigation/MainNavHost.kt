package com.leoevg.udemytraining.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoevg.udemytraining.screens.CurConverter
import com.leoevg.udemytraining.screens.DaggerHiltExampleScreen
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
        startDestination = NavigationPath.StartNazvanie
    ) {
        composable<NavigationPath.StartNazvanie> {
            StartScreen { path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.HelloWorldNazvanie> {
            HelloWorld()
        }
        composable<NavigationPath.GreetingAppNazvanie> {
            GreetingApp{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.CurConverterNazvanie> {
            CurConverter{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.FragmentAppNazvanie> {
            FragmentApp{ path ->
                navController.navigate(path)
            }
        }
        composable<NavigationPath.DaggerExampleNazvanie> {
            DaggerHiltExampleScreen(
                navigate = { path ->
                    navController.navigate(path)
                }
            )
        }
    }
}