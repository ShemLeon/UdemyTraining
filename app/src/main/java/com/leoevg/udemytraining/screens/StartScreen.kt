package com.leoevg.udemytraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.MainNavHost
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue
import com.leoevg.udemytraining.ui.theme.BlueGrey
import com.leoevg.udemytraining.ui.theme.Indigo
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
        CustomBtn(Modifier, "1. HelloWorld", Indigo){
            navigate(NavigationPath.HelloWorldSealed)
        }
        CustomBtn(Modifier, "2. GreetingApp", Indigo){
            navigate(NavigationPath.GreetingAppSealed)
        }
        CustomBtn(Modifier, "3. CurrencyConverter", Indigo){
            navigate(NavigationPath.CurConverterSealed)
        }
        CustomBtn(Modifier, "4. Fragments", Indigo){
            navigate(NavigationPath.FragmentAppSealed)
        }
        CustomBtn(Modifier, "5. Dagger Hilt", Blue){
            navigate(NavigationPath.ExampleDaggerSealed)
        }
        CustomBtn(Modifier, "6. ViewModel", Blue){
            navigate(NavigationPath.ExampleViewModelSealed)
        }
        CustomBtn(Modifier, "7. Lazy Row", Blue){
            navigate(NavigationPath.ExampleLazyRowSealed)
        }
        CustomBtn(Modifier, "8. Custom Component", Blue){
            navigate(NavigationPath.ExampleCustomComponentSealed)
        }
        CustomBtn(Modifier, "9. Life Cycle", Blue){
            navigate(NavigationPath.ExampleActivityLifeCycleSealed)
        }
        CustomBtn(Modifier, "10. SnackBar", Blue){
            navigate(NavigationPath.ExampleSnackBar)
        }
        CustomBtn(Modifier, "11. RetroFit", Green){
            navigate(NavigationPath.ExampleRetroFit)
        }


    }
}

@Composable
fun CustomBtn(
    modifier: Modifier,
    textContent: String,
    color: Color,
    navigate: (NavigationPath) -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        onClick = {
            navigate(NavigationPath.ExampleCustomComponentSealed)
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

@Preview(showBackground = true)
@Composable
fun StartScreen() {
    UdemyTrainingTheme {
        MainNavHost()
    }
}
