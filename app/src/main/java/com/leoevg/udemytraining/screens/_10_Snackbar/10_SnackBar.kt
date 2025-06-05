package com.leoevg.udemytraining.screens._10_Snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost // Для вложенной навигации
import androidx.navigation.compose.composable // Для вложенной навигации
import androidx.navigation.compose.rememberNavController // Для вложенной навигации
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
private data object SnackBarScreenA
@Serializable
private data object SnackBarScreenB

@Composable
fun ExampleSnackBar(
    navigateBack: () -> Unit = {}
    ){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val localNavController = rememberNavController()

    ObserveAsEvents(
        flow = SnackBarController.events,
        key1 = snackbarHostState
    ) { event ->
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = SnackbarDuration.Short
            )
            if (result == SnackbarResult.ActionPerformed){
                event.action?.action?.invoke()
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = Modifier.fillMaxSize()
    ){
        innerPadding ->
        NavHost(
            navController = localNavController,
            startDestination = SnackBarScreenA,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<SnackBarScreenA> {
                ScreenA(
                    onNavigate = {
                        localNavController.navigate(SnackBarScreenB)
                    })
            }
            composable<SnackBarScreenB> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFB2B2FF),
                                    Color(0xFF6666FF),
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Screen B (внутри ExampleSnackBar)",
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExampleSnackBar(){
    UdemyTrainingTheme{
        ExampleSnackBar()
    }
}



