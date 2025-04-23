package com.leoevg.udemytraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue

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
        CustomComponentBtn(Modifier.fillMaxWidth(), "Custom btn", Blue)
    }

}

@Composable
fun CustomComponentBtn(
    modifier: Modifier,
    textContent: String,
    color: Color,
    onCLick: () -> Unit = {}
){
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
            disabledContentColor = color),
        onClick = {
           // navigate(NavigationPath.ExampleDaggerSealed)
        }
    ) {
        Text(
            text = textContent,
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
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