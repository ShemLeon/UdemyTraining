package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MainApi {
    // получение по базовому запросу
    @GET("products/{id}") // ретрофит добавляет к базовой ссылке наш указатель
    suspend fun getProductById(@Path("id") id: Int): Product

    // отправка по базовому запросу
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): User
}