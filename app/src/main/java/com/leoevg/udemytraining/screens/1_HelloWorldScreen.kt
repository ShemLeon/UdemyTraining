package com.leoevg.udemytraining.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun HelloWorld(
    navigate: (NavigationPath) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(
            "Hello world!",
            fontSize = 40.sp,
            color = Color.Blue
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HelloWorldPreview() {
    UdemyTrainingTheme {
        HelloWorld()
    }
}
