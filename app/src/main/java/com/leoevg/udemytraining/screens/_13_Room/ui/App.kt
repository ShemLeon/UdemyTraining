package com.leoevg.udemytraining.screens._13_Room.ui

import android.app.Application
import com.leoevg.udemytraining.screens._13_Room.data.MainDB
import kotlin.getValue

class App : Application() {
    val database by lazy { MainDB.createDataBase(this) }
}