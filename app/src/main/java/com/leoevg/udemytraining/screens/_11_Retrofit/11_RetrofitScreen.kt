package com.leoevg.udemytraining.screens._11_Retrofit

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.retrofit.ProductApi
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ExampleRetroFit(
    navigate: (NavigationPath) -> Unit = {}
) {
    // 1. Создаем и "запоминаем" экземпляр API, чтобы не пересоздавать его постоянно
    val productApi = remember{
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")   // базовая ссылка
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ProductApi::class.java)
    }
    // 2. Создаем CoroutineScope, привязанный к жизненному циклу экрана
    val scope = rememberCoroutineScope()
    // 3. Создаем переменную состояния для текста. Compose будет следить за ее изменениями.
    var productText by remember { mutableStateOf("жми кнопку") }
    // productApi.getProductById() - теперь можно получить продукт по ссылке

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 4. Этот текст будет автоматически обновляться при изменении productText
        Text(
            text = productText,
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.CenterHorizontally),

            lineHeight = 50.sp,
            fontSize = 40.sp,
            color = Color.Blue
        )
        Button(
            onClick = {
                productText = "Загрузка..."
                // Запускаем корутину для выполнения сетевого запроса
                scope.launch {
                    try {
                        // Выполняем запрос к API
                        val product = productApi.getProductById()
                        // В случае успеха обновляем текст названием продукта
                        productText = product.title
                        Log.d("MyLog", "Product loaded: $product")
                    } catch (e: Exception) {
                        // В случае ошибки показываем сообщение
                        productText = "Ошибка загрузки!"
                        Log.e("MyLog", "Error loading product", e)
                    }
                }
            }
        ) {
            Text("GET")
        }
    }
}


@Composable
@Preview(showBackground = true)
fun RetroFitExamplePreview() {
    UdemyTrainingTheme {
        ExampleRetroFit()
    }
}