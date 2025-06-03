package com.leoevg.udemytraining.screens
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.viewmodels._9_ActivityLifeCycleViewModel

@Composable
fun ExampleActivityLifeCycle(
    navigate: (NavigationPath) -> Unit = {},
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
){
    val viewModel: _9_ActivityLifeCycleViewModel= viewModel()

    val context = LocalContext.current
    val toastMessage = viewModel.toastMessage

    LaunchedEffect(toastMessage) {
        toastMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            viewModel.toastMessage = null
        }
    }

    // отслеживание состояния
    DisposableEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(viewModel)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(viewModel)
        }
    }

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
// 1. onCreate
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnCreate),
            textAlign = TextAlign.Center,
            text = "1. onCreate!",
            fontSize = 28.sp,
            color = viewModel.textColorOnCreate,
        )
// 2. onStart
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnStart),
            textAlign = TextAlign.Center,
            text = " 2. onStart ",
            fontSize = 28.sp,
            color = viewModel.textColorOnStart,
        )
// 3. onResume
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnResume),
            textAlign = TextAlign.Center,
            text = "3. onResume",
            fontSize = 28.sp,
            color = viewModel.textColorOnResume,
        )
// 4. onPause
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnPause),
            textAlign = TextAlign.Center,
            text = " 4. onPause ",
            fontSize = 28.sp,
            color = viewModel.textColorOnPause,
        )
// 5. onStop
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnStop),
            textAlign = TextAlign.Center,
            text = "5. onStop",
            fontSize = 28.sp,
            color = viewModel.textColorOnStop,
        )
// 6. onDestroy
        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .background(color = viewModel.colorOnDestroy),
            textAlign = TextAlign.Center,
            text = "5. onDestroy",
            fontSize = 28.sp,
            color = viewModel.textColorOnDestroy,
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewExampleActivityLifeCycle(){
    ExampleActivityLifeCycle()
}

