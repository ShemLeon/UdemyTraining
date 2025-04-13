package com.leoevg.udemytraining.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoevg.udemytraining.data.SayByeByeManager
import com.leoevg.udemytraining.data.SayHelloWorldManager
import com.leoevg.udemytraining.data.UserManager
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import com.leoevg.udemytraining.viewmodels.DaggerExampleViewModel
import javax.inject.Inject

@Composable
fun DaggerHiltExample(
    navigate: (NavigationPath) -> Unit = {},
    viewModel: DaggerExampleViewModel = hiltViewModel()
) {
    var message by remember { mutableStateOf("") }
    var message2 by remember { mutableStateOf("") }

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        val toastMessage = viewModel.sayHello()
        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show()
    }

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

        // Btn_DH1
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

        // Btn_DH2
        Button(
            onClick = {
                message2 = viewModel.sayBye()
            }
        ) { Text("Give me Bye!") }

        if (message2.isNotEmpty()) {
            Text(
                text = message2,
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.padding(top = 20.dp)
            )
        }



        // Btn_Home
        Button(
            onClick = { navigate(NavigationPath.StartNazvanie) },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaggerHiltExampleScreen(){
    UdemyTrainingTheme(){
        // Создаем фейковый ViewModel для Preview
        val previewViewModel = object : DaggerExampleViewModel(
            SayHelloWorldManager("Preview"),
            SayByeByeManager(UserManager("preview", "preview", "preview"))
        ) {}
        DaggerHiltExample(viewModel = previewViewModel)
    }
}