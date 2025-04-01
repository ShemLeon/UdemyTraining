package com.leoevg.udemytraining.screens

import android.widget.TextView
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.leoevg.udemytraining.R
import com.leoevg.udemytraining.navigation.NavigationPath

import com.leoevg.udemytraining.ui.theme.BlueGrey
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun CurConverter(
    navigate: (NavigationPath) -> Unit = {}
){
    var dollars by remember { mutableStateOf("") }


    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = "Currency Converter App!",
                fontSize = 28.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 30.dp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 80.dp),
                value = dollars,
                onValueChange = { dollars = it },
                placeholder = {
                    Text(text = "Enter USD")
                },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    disabledContainerColor = BlueGrey,
                    focusedContainerColor = BlueGrey,
                    errorContainerColor = BlueGrey,
                    unfocusedContainerColor = BlueGrey
                )
            )

        }
}


@Composable
@Preview(showBackground = true)
fun CurConverterPreview(){
    UdemyTrainingTheme {
        CurConverter{}
    }
}
