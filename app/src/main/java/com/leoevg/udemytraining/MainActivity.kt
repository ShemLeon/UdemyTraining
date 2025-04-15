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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leoevg.udemytraining.navigation.MainNavHost
import com.leoevg.udemytraining.screens.sayHello
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ф-я настраивает дисплей приложения
        enableEdgeToEdge()

        setContent {
            UdemyTrainingTheme {
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