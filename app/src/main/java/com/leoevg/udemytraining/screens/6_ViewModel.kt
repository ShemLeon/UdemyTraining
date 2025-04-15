package com.leoevg.udemytraining.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun ExampleViewModel(
    navigate: (NavigationPath) -> Unit={}
){
    Column {  }

}


@Composable
@Preview (showBackground = true)
fun ExampleViewModelPreview(){
    UdemyTrainingTheme {
        ExampleViewModel{}
    }
}