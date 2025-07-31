package com.leoevg.udemytraining.screens._1_HelloWorld_SnackBar

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.launch

@Composable
fun HelloWorld(
    navigate: (NavigationPath) -> Unit = {}
) {
    // 1. создаем объект для вызова корутины
    val coroutineScope = rememberCoroutineScope()
    // 2. отдельный state для snackBar
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hello world!",
                fontSize = 40.sp,
                color = Color.Blue
            )
            Button(
                modifier = Modifier.fillMaxWidth(0.9f),
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Item deleted"
                        )
                    }
                }
            ) {
                Text(
                    text = "simple snackBar",
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 48.sp,
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 15.dp),
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Action close -->",
                            actionLabel = "Close"
                        )
                    }
                }
            ) {
                Text(
                    text = "action snackBar",
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                )
                Log.d("MyLog", "HelloWorld: ")
                myFun()
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HelloWorldPreview() {
    UdemyTrainingTheme {
        HelloWorld()
    }
}

private fun myFun(){
    val number = "56".toInt()

}