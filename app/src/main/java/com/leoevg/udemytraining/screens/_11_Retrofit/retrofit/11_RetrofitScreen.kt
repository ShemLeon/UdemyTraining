package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

import android.R.attr.textSize
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ExampleRetroFit(
    navigate: (NavigationPath) -> Unit = {}
) {
    // 4. okHttp
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    // 1. Создаем и "запоминаем" экземпляр API, чтобы не пересоздавать его постоянно
    val mainApi = remember{
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }
    // 2. Создаем CoroutineScope, привязанный к жизненному циклу экрана
    val scope = rememberCoroutineScope()
    // 3. Создаем переменную состояния для текста. Compose будет следить за ее изменениями.
    var productText by remember { mutableStateOf("жми кнопку") }
    var imageUrl by remember { mutableStateOf<String?>(null) }
    var counter by remember { mutableIntStateOf(1) }


    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .padding(top = 30.dp)
                .border(BorderStroke(2.dp, Color.Black)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // 4. Этот текст будет автоматически обновляться при изменении productText
            Text(
                text = productText,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                ,
                lineHeight = 50.sp,
                fontSize = 40.sp,
                color = Color.Blue,
                maxLines = 1 // Показываем текст только в одну строку
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ){
                if(imageUrl != null) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "product image",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop
                    )
                } else {
            // Можно добавить Placeholder, если userImageUrl == null
            Box(modifier = Modifier.size(80.dp)
                .background(Color.LightGray) // Пример плейсхолдера
            )}
        }
            Button(
                onClick = {
                    productText = "Загрузка..."
                    imageUrl = null
                    // Запускаем корутину для выполнения сетевого запроса
                    scope.launch {
                        try {
                            // Выполняем запрос к API
                            val product = mainApi.getProductById(counter)
                            // В случае успеха обновляем текст названием продукта
                            productText = product.title
                            imageUrl = product.thumbnail
                            Log.d("MyLog", "Product loaded: $product")
                            counter++
                        } catch (e: Exception) {
                            // В случае ошибки показываем сообщение
                            productText = "Ошибка загрузки!"
                            Log.e("MyLog", "Error loading product", e)
                        }
                    }
                }
            ) {
                Text(
                    text = "GET",
                    fontSize = 25.sp
                    )
            }
            }

        }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
        ,
        onClick = {
            navigate(NavigationPath.ExampleRetrofitAuth)
        }
    ) {
        Text(
            modifier = Modifier

                .padding(5.dp),
            text = "AUTH with RETROFIT",
            fontSize = 25.sp,
        )
    }  }

}


@Composable
@Preview(showBackground = true)
fun RetroFitExamplePreview() {
    UdemyTrainingTheme {
        ExampleRetroFit()
    }
}
