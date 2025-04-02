package com.leoevg.udemytraining.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme


@Composable
fun FragmentApp(
    navigate: (NavigationPath) -> Unit = {}
) {
    val currentFragment = remember { mutableStateOf("login") }
    val screenWidth = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    
    // Настройки подчеркивания
    val indicatorWidth = 40.dp
    
    val indicatorOffset by animateDpAsState(
        targetValue = when (currentFragment.value) {
            "login" -> screenWidth.value / 4 - indicatorWidth / 2
            else -> 3 * screenWidth.value / 4 - indicatorWidth / 2
        },
        label = "indicatorOffset"
    )
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Верхняя панель навигации
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00A86B))
                .onGloballyPositioned { coordinates ->
                    screenWidth.value = with(density) { coordinates.size.width.toDp() }
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=20.dp)
            ) {
                TextButton(
                    onClick = { currentFragment.value = "login" },
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        "Login",
                        color = Color.White,
                        fontSize = 30.sp
                    )
                }
                
                TextButton(
                    onClick = { currentFragment.value = "register" },
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        "Register",
                        color = Color.White,
                        fontSize = 30.sp
                    )
                }
            }
            
            // Индикатор активной вкладки (подчеркивание)
            Box(
                modifier = Modifier
                    .offset(x = indicatorOffset)
                    .width(indicatorWidth)
                    .align(Alignment.BottomStart)
                    .height(8.dp)
                    .background(Color.White)
            )
        }
        
        // Содержимое фрагмента
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (currentFragment.value) {
                "login" -> LoginFragment()
                "register" -> RegisterFragment()
            }
        }
    }
}

@Composable
fun LoginFragment() {
    Text(
        "FragmentLogin",
        fontSize = 24.sp,
        color = Color(0xFF9CCC65),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun RegisterFragment() {
    Text(
        "FragmentRegister",
        fontSize = 24.sp,
        color = Color(0xFF9CCC65),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
    )
}



@Composable
@Preview(showBackground = true)
fun FragmentAppPreview() {
    UdemyTrainingTheme {
        FragmentApp()
    }
}