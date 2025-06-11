package com.leoevg.udemytraining.screens._11_Retrofit.retrofit

data class Product (
    val id: Int,
    val title: String,
    val description: String = "description",
    val price: Double = 0.0,
    val discountPercentage: Float = 0.0f,
    val rating: Double = 0.0,
    val stock: Int = 0,
    val brand: String = "",
    val category: String = "",
    val thumbnail: String = "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
    val images: List<String> = listOf()
)