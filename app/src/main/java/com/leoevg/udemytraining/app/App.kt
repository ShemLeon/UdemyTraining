package com.leoevg.udemytraining.app
import android.app.Application
import com.leoevg.udemytraining.screens._13_Room.data.MainDB
import dagger.hilt.android.HiltAndroidApp
import kotlin.getValue

// этот класс будет запускатся сразу после создания приложения.
// благодаря манифесту и хилту.
@HiltAndroidApp
class App: Application(){
    val database by lazy { MainDB.createDataBase(this) }
}