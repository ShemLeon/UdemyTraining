package com.leoevg.udemytraining.retrofit

data class Product (
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Float,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)