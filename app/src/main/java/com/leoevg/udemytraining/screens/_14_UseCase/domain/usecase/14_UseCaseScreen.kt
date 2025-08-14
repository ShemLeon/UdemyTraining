package com.leoevg.udemytraining.screens._14_UseCase.domain.usecase

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.SaveUserNameParam
import com.leoevg.udemytraining.screens._14_UseCase.domain.models.UserName
import com.leoevg.udemytraining.ui.theme.Blue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun UseCaseScreen(
    navigate: (NavigationPath) -> Unit = {}
) {
    val getUserNameUseCase = GetUserNameUseCase()
    val saveUserNameUseCase = SaveUserNameUseCase()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, end = 16.dp, top = 100.dp),
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("No data") },
            modifier = Modifier.fillMaxWidth()
        )
        // кнопка Get data
        Button(
            onClick = {
                val userName: UserName = getUserNameUseCase.execute()
                dataTextView.text = "${userName.firstName} ${userName.lastName}"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "GET DATA",
                fontSize = 30.sp
            )
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Put your data here") },
            modifier = Modifier.fillMaxWidth()
        )
        // кнопка Save data
        Button(
            onClick = {
                val text = getUserNameUseCase.execute().toString()
                val params = SaveUserNameParam(name = text)
                val result: Boolean = saveUserNameUseCase.execute(params = params)
                dataTextView.text = "Save result = $result"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "SAVE DATA",
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
fun UseCaseScreenPreview(){
    UseCaseScreen()
}