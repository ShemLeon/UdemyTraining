package com.leoevg.udemytraining.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// этот класс будет запускатся сразу после создания приложения.
// благодаря манифесту и хилту.
@HiltAndroidApp
class App: Application(){

}