package com.leoevg.udemytraining.retrofit

import retrofit2.http.GET

interface ProductApi {
    @GET("products/1") // ретрофит добавляет к базовой ссылке наш указатель
    suspend fun getProductById(): Product
}