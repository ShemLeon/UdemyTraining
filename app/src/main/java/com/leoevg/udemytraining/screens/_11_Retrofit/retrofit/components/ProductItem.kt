package com.leoevg.udemytraining.screens._11_Retrofit.retrofit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.leoevg.udemytraining.screens._11_Retrofit.retrofit.Product
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
){
    // общий row
    Row(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray.copy(alpha = 0.3f))
            .padding(8.dp)
    ) {
        // часть с текстом
        Column(
            modifier = modifier
                .weight(1f) // Занимает все доступное место
                .padding(end = 8.dp) // Отступ справа от картинки
        ) {
            Text(
//                text = "Title",
                text = product.title,
                modifier = Modifier.padding(2.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
//                text = "Description",
                text = product.description,
                fontSize = 20.sp,
                maxLines = 3
            )
        }
        // часть с изображением
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp),
            contentAlignment = Alignment.Center
            ){
                var imageUrl = null
                if(imageUrl != null) {
                    AsyncImage(
                        model =  product.thumbnail,
                        contentDescription = "product image",
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                } else {
                    // Пример плейсхолдера
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color.LightGray,
                            shape = RoundedCornerShape(12.dp))
                    )
                }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ProductItemPreview(){
        val fakeProduct = Product(
            id = 1,
            title = "Айфон 40",
            description = "Яблоко в руках, ананас в африке, арбуз на баште, собака на сене, груша на груше",
            thumbnail = "https://i.dummyjson.com/data/products/1/thumbnail.jpg"
        )
    UdemyTrainingTheme(){
    ProductItem(product = fakeProduct)
    }
}