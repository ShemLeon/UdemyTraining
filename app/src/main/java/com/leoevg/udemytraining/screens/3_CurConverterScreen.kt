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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun CurConverter(
    navigate: (NavigationPath) -> Unit = {}
){
    var dollars by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1E3B70),  // Темно-синий
                            Color(0xFF29B6F6),  // Голубой
                            Color(0xFF81D4FA)   // Светло-голубой
                        )
                    )
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

        )  {
            Text(
                text = "Currency Converter App!",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 30.dp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 80.dp),
                value = dollars,
                onValueChange = {
                    dollars = it
                                },
                placeholder = {
                    Text(text = "Enter USD", color = Color.Gray)
                },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    disabledContainerColor = Color.White.copy(alpha = 0.9f),
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    errorContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                    cursorColor = Color.Black
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp
                )
            )
//btn "Convert"
        Button(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.8f)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {
                val usdAmount = dollars.toDoubleOrNull() ?: 0.0
                val shekelAmount = makeConversion(usdAmount)
                result = String.format("%.2f", shekelAmount)
            }
        ){
            Text(
                text = "Convert to Shekel",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 48.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = result,
            fontSize = 68.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 30.dp)
        )
// btn "Go Home"
        Button(
                modifier = Modifier
                   .fillMaxWidth(fraction = 0.8f)
                   .padding(top = 160.dp),
                colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {
                navigate(NavigationPath.StartSealed)
            }
            ){
                Text(
                    text = "Back to main",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }



    }
}

fun makeConversion(usd: Double):Double{
    var shekels: Double = usd * 3.85
    return shekels
}


@Composable
@Preview(showBackground = true)
fun CurConverterPreview(){
    UdemyTrainingTheme {
        CurConverter{}
    }
}
