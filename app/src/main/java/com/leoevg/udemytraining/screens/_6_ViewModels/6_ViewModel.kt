package com.leoevg.udemytraining.screens._6_ViewModels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.udemytraining.R
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun ExampleViewModel(
    navigate: (NavigationPath) -> Unit = {}
) {
    val viewModel: _6_ScreenExampleViewModel = viewModel()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.background_image),
            contentDescription = "background image",
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.3f))
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Title
            Text(
                text = "Example ViewModel",
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 30.dp),
            )
            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // add weight for flexibility
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Login",
                    color = Color.Black,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    value = viewModel.email,
                    onValueChange = {
                        viewModel.email = it
                    },
                    placeholder = {
                        Text("User Name")
                    },
                    modifier = Modifier.padding(top = 20.dp)
                )
                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = {
                        viewModel.password = it
                    },
                    placeholder = {
                        Text("Password")
                    },
                    modifier = Modifier.padding(top = 20.dp)
                )

                viewModel.error?.let { error ->
                    Text(
                        text = error,
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Red, RoundedCornerShape(15.dp))
                            .padding(horizontal = 15.dp, vertical = 10.dp)
                    )
                }
            }
            Button(
                onClick = {
                    viewModel.login()
                    viewModel.navigateTo?.let { path ->
                        navigate(path)
                        viewModel.navigateTo = null
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 36.sp
                )

            }

        }
    }


}


@Composable
@Preview(showBackground = true)
fun ExampleViewModelPreview() {
    UdemyTrainingTheme {
        ExampleViewModel {}
    }
}