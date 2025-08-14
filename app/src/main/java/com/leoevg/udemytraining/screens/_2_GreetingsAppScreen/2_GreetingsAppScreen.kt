package com.leoevg.udemytraining.screens._2_GreetingsAppScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import com.leoevg.udemytraining.R
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue
import com.leoevg.udemytraining.ui.theme.BlueGrey
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun GreetingApp(
    navigate: (NavigationPath) -> Unit = {}

){
    var name by remember { mutableStateOf("") }
    var language by remember { mutableStateOf("") }
    var showLogo by remember { mutableStateOf(false) }
    var isJava by remember { mutableStateOf(true) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome to our App!",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 30.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 80.dp),
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(text = "Please enter your name")
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

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 20.dp),
            value = language,
            onValueChange = { language = it },
            placeholder = {
                Text(text = "What language you prefer: Java or Kotlin?")
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

        Button(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.8f)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {
                // параметр по умолчанию
                isJava = language.equals("Java", ignoreCase = true)
                Toast.makeText(context,"Shalom, $name!",Toast.LENGTH_LONG).show()
                showLogo = true
            }
        ) {
            Text(
                text = "Say Hello",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        if (showLogo) {
            val imgResId: Int
            if (isJava) imgResId = R.drawable.javalogo
            else imgResId = R.drawable.kotlinlogo

            Image(
                painter = painterResource(id = imgResId),
                contentDescription = if (isJava) "Java Logo" else "Kotlin Logo",
                modifier = Modifier
                    .padding(top = 40.dp)
                    .size(200.dp)
            )
            
            Text(
                text = "Your choice is ${if (isJava) "Java" else "Kotlin"}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if (isJava) Color(0xFFE76F00) else Color(0xFF7F52FF),
                modifier = Modifier.padding(top = 16.dp)
            )
            
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .padding(top = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    navigate(NavigationPath.StartSealed)
                }
            ) {
                Text(
                    text = "Back to main",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingsPreview(){
    UdemyTrainingTheme {
        GreetingApp{}
    }
}
