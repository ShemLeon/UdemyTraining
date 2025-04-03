package com.leoevg.udemytraining.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.viewmodels.DaggerExampleViewModel

@Composable
fun DaggerHiltExampleScreen(
    navigate: (NavigationPath) -> Unit = {},
    viewModel: DaggerExampleViewModel = hiltViewModel()
) {
    var message by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dagger Hilt Example",
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        
        Button(
            onClick = {
                message = viewModel.sayHello()
            }
        ) { Text("Give me Hello!") }

        if (message.isNotEmpty()) {
            Text(
                text = message,
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        
        Button(
            onClick = { navigate(NavigationPath.StartNazvanie) },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Back")
        }
    }
} 