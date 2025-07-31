package com.leoevg.udemytraining.screens._12_Experiments

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
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
        Column(
            modifier = Modifier
                .widthIn(min = 100.dp, max=500.dp)
                .padding(16.dp, end = 16.dp, top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
          BasicText(
                text = "Please share more about yourself",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                maxLines = 2,
                autoSize = TextAutoSize.StepBased(
                    minFontSize = 10.sp,
                    maxFontSize = 38.sp
                ),
            )
            Text(
                text = "Это поможет нам выучить больше о тебе и улучшить твое приложение",
                modifier = Modifier.fillMaxWidth()
            )


        }
        Spacer(modifier = Modifier.weight(1f))


        // btn "Go Home"
        Card(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1f)
                .padding(bottom = 80.dp),
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
fun ExperimentsScreenPreview(){
    ExperimentsScreen()
}