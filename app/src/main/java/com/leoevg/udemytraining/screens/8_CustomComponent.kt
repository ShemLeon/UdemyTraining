package com.leoevg.udemytraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leoevg.udemytraining.navigation.NavigationPath

@Composable
fun ExampleCustomComponent(
    navigate: (NavigationPath) -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomComponent(modifier = Modifier.padding(top=150.dp))
        CustomComponent(modifier = Modifier
            .padding(top = 300.dp, start = 50.dp)
            .background(Color.Yellow, RoundedCornerShape(1.dp)))
        CustomComponent(modifier = Modifier
            .padding(start = 50.dp)
            .background(Color.Green)
        )
    }
}

@Composable
fun CustomComponent(modifier: Modifier){
    Column (
        modifier = modifier
           // .background(Color.Yellow, RoundedCornerShape(15.dp))
            .padding(20.dp)
    ){
        Text("Custom Component")
    }
}

@Composable
@Preview(showBackground = true)
fun ExampleCustomComponentPreview(){
    ExampleCustomComponent{}
}