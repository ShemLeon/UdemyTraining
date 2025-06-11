package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

import android.R.attr.textSize
import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
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
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.components.ProductItem
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ExampleRetrofitList(
    navigate: (NavigationPath) -> Unit = {}
) {
    // 1. Настройка Retrofit
   val mainApi = remember {
       val interceptor = HttpLoggingInterceptor().apply {
           level = HttpLoggingInterceptor.Level.BODY
       }
       val client = OkHttpClient.Builder()
           .addInterceptor(interceptor)
           .build()
       Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
           .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }
    // 2. Состояния для списка продуктов и статуса загрузки
    var productList by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // 3. Загрузка данных при первом запуске экрана
    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val response = mainApi.getAllProducts()
            productList = response.products
            Log.d("MyLog", "Product loaded: ${productList.size} items")
        } catch (e: Exception){
            errorMessage = "ОШИБКА ЗАГРУЗКИ: ${e.message}"
            Log.e("MyLog", "ОШИБКА ЗАГРУЗКИ PRODUKTOV", e)
        } finally {
            isLoading = false
        }
    }


// 4. Основной UI
Column(
    modifier = Modifier.fillMaxSize().padding(15.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    // Показываем индикатор загрузки
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (errorMessage != null) {
        // Показываем сообщение об ошибке
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = errorMessage!!,
                color =Color.Red,
                fontSize = 20.sp
            )
        }
    }else {
        // Показываем список продуктов
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productList) { product ->
                ProductItem(product = product)
            }
        }
    }

    }

}



@Composable
@Preview(showBackground = true)
fun RetrofitListExamplePreview() {
    UdemyTrainingTheme {
        ExampleRetroFit()
    }
}



/*

binding = ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)

adapter = ProductAdapter()
binding.rcView.layoutManager = LinearLayoutmanager(this)
binding.rcView.adapter=adapter
adapter.submitList()

// 1. okHttp
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    // 2. Создаем и "запоминаем" экземпляр API, чтобы не пересоздавать его постоянно
    val mainApi = remember{
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }

 val mainApi = remember{
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }
    // 2. Создаем CoroutineScope, привязанный к жизненному циклу экрана
    val scope = rememberCoroutineScope()

    coroutineScope(dispatchers.IO).launch{
    val list = mainApi.getAllProducts()
    runOnUiThread


    class ProductAdapter : ListAdapter<Product ProductAdapter.Holder>(Comparator()){

        class Holder(view: View) : recyclerView.ViewHolder(view){
         private val binding = ListItemBinding.bind(view)

        fun bind(product: product) = with(binding){
            title.text = product.title
            description.text = product.description
            Picasso.get().load(product.thumbnail).into(image)
        }

        class Comparator: Diffuutil.ItemCallBack<Product>(){
        override fun areItemsTheSame(oldItem: product, newItem: product): Boolean{
            return = oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: product, newItem: product): Boolean{
               return = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int){
        holder.bind(getItem())
    }




 */