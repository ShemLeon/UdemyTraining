package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.AuthRequest
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.MainApi
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ExampleRetrofitAuth(
    navigate: (NavigationPath) -> Unit = {}
) {
    // 4. okHttp
    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = okhttp3.OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    // 1. Создаем и "запоминаем" экземпляр API, чтобы не пересоздавать его постоянно
    val mainApi = remember {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)   // базовая ссылка
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }
    // 2. Создаем CoroutineScope, привязанный к жизненному циклу экрана
    val scope = rememberCoroutineScope()
    // 3. Создаем переменную состояния для текста. Compose будет следить за ее изменениями.
    var entryEmail by remember { mutableStateOf("") }
    var entryPassword by remember { mutableStateOf("emilyspass") }
    var userNick by remember { mutableStateOf("залогинься") }
    var userImageUrl by remember { mutableStateOf<String?>(null) }

    var loginError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .border(BorderStroke(2.dp, Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            if (userImageUrl != null) {
                AsyncImage(
                    model = userImageUrl,
                    contentDescription = "user image",
                    modifier = Modifier
                        .size(80.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                // Можно добавить Placeholder, если userImageUrl == null
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.LightGray) // Пример плейсхолдера
                )
            }
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 55.dp),
            value = entryEmail,
            onValueChange = { entryEmail = it; loginError = null },
            label = { Text("Имя пользователя (username)") },
            placeholder = { Text("email") },
            shape = RoundedCornerShape(15.dp),
            isError = loginError != null // Подсвечиваем поле при ошибке
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 55.dp),
            value = entryPassword,
            onValueChange = { entryPassword = it; loginError = null }, // Сбрасываем ошибку при вводе
            label = { Text("Пароль") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            isError = loginError != null // Подсвечиваем поле при ошибке
        )

        if (loginError != null) {
            Text(
                text = loginError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Button(
            onClick = {
                if (entryEmail.isBlank() || entryPassword.isBlank()) {
                    loginError = "Имя пользователя и пароль не могут быть пустыми."
                    return@Button
                }
                userNick = "Загрузка..."
                userImageUrl = null
                // Запускаем корутину для выполнения сетевого запроса
                CoroutineScope(Dispatchers.IO).launch {
                    // Выполняем запрос к API
                    val user = mainApi.auth(
                        AuthRequest(
                            entryEmail.toString(),
                            entryPassword.toString()
                        )
                    )
                    // В случае успеха обновляем текст и имя юзера
                    userNick = user.userName
                    userImageUrl = user.image
                    Log.d("MyLog", "User loaded: $user")
                }
            }


        ) {
            Text("LOGIN")
        }
        Text(
            modifier = Modifier

                .padding(5.dp),
            text = "emilys \n emilyspass ",
            fontSize = 25.sp,
        )
    }
}



@Composable
@Preview(showBackground = true)
fun RetrofitAuthExamplePreview() {
    UdemyTrainingTheme {
        ExampleRetrofitAuth()
    }
}
