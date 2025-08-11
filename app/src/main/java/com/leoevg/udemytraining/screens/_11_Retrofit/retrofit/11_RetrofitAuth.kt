package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
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

    // 3. Создаем переменную состояния для текста. Compose будет следить за ее изменениями.
    var entryEmail by remember { mutableStateOf("emilys") }
    var entryPassword by remember { mutableStateOf("emilyspass") }
    var userNick by remember { mutableStateOf("залогинься") }
    var userImageUrl by remember { mutableStateOf<String?>(null) }
    var loginError by remember { mutableStateOf<String?>(null) }
    var placeholderColor by remember { mutableStateOf(Color.LightGray) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .border(BorderStroke(2.dp, Color.Black)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Box для изображения или плейсхолдера
        Box(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .aspectRatio(1f) // расположение квадратиком
                .padding(top = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            // Показываем картинку
            if (userImageUrl != null && loginError == null) {
                AsyncImage(
                    model = userImageUrl,
                    contentDescription = "user image",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
                            shape = RoundedCornerShape(12.dp)
                        )
                )
            } else {
                // Плейсхолдер
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = placeholderColor,
                            shape = RoundedCornerShape(12.dp)
                        )
                )
            }
        }
        Text(
            text = userNick,
            color = if (placeholderColor == Color.Red)
                Color.Red else Color.Black,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 55.dp),
            value = entryEmail,
            onValueChange = {
                entryEmail = it;
                loginError = null
                placeholderColor = Color.LightGray
                            },
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
            onValueChange = {
                entryPassword = it
                loginError = null
                placeholderColor = Color.LightGray
                            }, // Сбрасываем ошибку при вводе
            label = { Text("Пароль") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            isError = loginError != null // Подсвечиваем поле при ошибке
        )

        Button(
            onClick = {
                if (entryEmail.isBlank() || entryPassword.isBlank()) {
                    loginError = "Имя пользователя и пароль не могут быть пустыми."
                    return@Button
                }
                userNick = "Загрузка..."
                userImageUrl = null
                loginError = null // Сбрасываем любую предыдущую ошибку 400/401
                placeholderColor = Color.LightGray
                // Запускаем корутину для выполнения сетевого запроса
                CoroutineScope(Dispatchers.IO).launch {
                    try{
                        Log.d("MyLog", "Attempting login with: $entryEmail")
                        val user = withContext(Dispatchers.IO) {
                            mainApi.auth(
                                AuthRequest(
                                    username = entryEmail.trim(),
                                    password = entryPassword
                                )
                            )
                        }
                        // УСПЕХ
                        userNick = user.username
                        userImageUrl = user.image
                        // placeholderColor остается Color.LightGray
                        Log.d("MyLog", "User loaded: ${user.firstName}, image: ${user.image}")
                    } catch (e: HttpException) {
                        Log.e("MyLog", "HTTP Error: ${e.code()}", e)
                        userNick = "Ошибка входа" // Общее сообщение для ника
                        userImageUrl = null // Убедимся, что картинки нет
                        placeholderColor = Color.Red // Красим плейсхолдер для ВСЕХ HTTP ошибок

                        if (e.code() == 400 || e.code() == 401) {
                            loginError = "Неверный логин или пароль." // Сообщение только для 400/401
                        } else {
                            loginError = null // Для других HTTP ошибок текстовое сообщение не показываем,
                            // но плейсхолдер останется красным
                        }
                    }
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
