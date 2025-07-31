package com.leoevg.udemytraining.screens._12_Experiments

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.Blue


@Composable
fun ExperimentsScreen(
    navigate: (NavigationPath) -> Unit = {}
){
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

    ) {




        // btn "Go Home"
        Button(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)
                .padding(bottom = 50.dp),
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

@Preview(showBackground = true)
@Composable
fun ExperimentsScreenPreview(){
    ExperimentsScreen()
}