package com.leoevg.udemytraining.screens._14_UseCase.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UseCaseScreen(
    navigate: (NavigationPath) -> Unit = {}
) {
    val viewModel: UseCaseViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, end = 16.dp, top = 100.dp),
    ) {
        OutlinedTextField(
            value = viewModel.displayText,
            onValueChange = {},
            label = {
                Text(
                    if (viewModel.displayText.isEmpty()) "No data"
                    else ""
                )
            },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )
        // кнопка Get data
        Button(
            onClick = {
                viewModel.getUserName()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "GET USER DATA",
                fontSize = 30.sp
            )
        }

        OutlinedTextField(
            value = viewModel.inputText,
            onValueChange = { viewModel.inputText = it },
            label = { Text("Put your data here") },
            modifier = Modifier.fillMaxWidth()
        )
        // кнопка Save data
        Button(
            onClick = {
                viewModel.saveUserName()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "SAVE USER DATA",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        // btn "Go Home"
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)
                .padding(bottom = 60.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 2.dp,
                        color = Color.Cyan.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                onClick = {
                    navigate(NavigationPath.StartSealed)
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Домой",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun UseCaseScreenPreview() {
    UseCaseScreen()
}