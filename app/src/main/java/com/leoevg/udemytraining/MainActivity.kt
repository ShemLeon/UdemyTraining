package com.leoevg.udemytraining

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.leoevg.udemytraining.data.SnackBarController
import com.leoevg.udemytraining.navigation.MainNavHost
import com.leoevg.udemytraining.screens._10_Snackbar.ObserveAsEvents
import com.leoevg.udemytraining.screens.sayHello
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import com.leoevg.udemytraining.screens._10_Snackbar._10_SnackBarViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data object ScreenA

@Serializable
data object ScreenB

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UdemyTrainingTheme {
                val snackbarHostState = remember{
                    SnackbarHostState()
                }
                val scope = rememberCoroutineScope()
                ObserveAsEvents(
                    flow = SnackBarController.events,
                    snackbarHostState
                ) { event ->
                    scope.launch {
                        val result = snackbarHostState.currentSnackbarData?.dismiss()

                        snackbarHostState.showSnackbar(
                            message = event.message,
                            actionLabel = event.action?.name,
                            duration = SnackbarDuration.Long
                        )

                        if (result == SnackbarResult.ActionPerformed){
                            event.action?.action?.invoke()
                        }
                    }
                }
                LaunchedEffect(key1 = true) {
                    SnackBarController.events.collect { event ->
                        snackbarHostState.showSnackbar()
                    }
                }

                Scaffold(
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ){ innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = 10_SnackBar
                    ){
                        composable<ScreenA>{}
                        composable<ScreenB>{}
                    }
                }
                UIMainTest()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UIMainTest() {
    UdemyTrainingTheme {
        MainNavHost()
    }
}