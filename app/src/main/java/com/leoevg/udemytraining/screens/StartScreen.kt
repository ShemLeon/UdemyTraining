package com.leoevg.udemytraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.MainNavHost
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun StartScreen(
    navigate: (NavigationPath) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Start Screen",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 10.dp),


        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),

            onClick = {
                navigate(NavigationPath.HelloWorldNazvanie)
            }
        ) {
            Text(
                text = "1. HelloWorld",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),

            onClick = {
                navigate(NavigationPath.GreetingAppNazvanie)
            }
        ) {
            Text(
                text = "2. GreetingApp",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),

            onClick = {
                navigate(NavigationPath.CurConverterNazvanie)
            }
        ) {
            Text(
                text = "3. CurrencyConverter",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),

            onClick = {
                navigate(NavigationPath. FragmentAppNazvanie)
            }
        ) {
            Text(
                text = "4. Fragments",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),

            onClick = {
                navigate(NavigationPath.ExampleDaggerNazvanie)
            }
        ) {
            Text(
                text = "5. Dagger Hilt",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navigate(NavigationPath.ExampleDaggerNazvanie)
            }
        ) {
            Text(
                text = "6. ViewModel",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StartScreen() {
    UdemyTrainingTheme {
        MainNavHost()
    }
}
