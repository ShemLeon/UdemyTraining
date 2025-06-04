package com.leoevg.udemytraining.screens._10_Snackbar

import androidx.compose.material3.MaterialTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.udemytraining.navigation.NavigationPath

@Composable
fun ExampleSnackBar(
    navigate: (NavigationPath) -> Unit = {},
    ){
    val viewModel: _10_SnackBarViewModel = viewModel ()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFB2FFB2),  // Светло-зелёный
                        Color(0xFF66FF99),  // Мятный
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = MaterialTheme.colorScheme.background),
            textAlign = TextAlign.Center,
            text = "SnackBar!",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewExampleSnackBar(){
    ExampleSnackBar()
}

