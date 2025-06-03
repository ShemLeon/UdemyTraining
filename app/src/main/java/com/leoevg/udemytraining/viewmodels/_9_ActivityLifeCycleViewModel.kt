package com.leoevg.udemytraining.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

class _9_ActivityLifeCycleViewModel: ViewModel(), DefaultLifecycleObserver {
    var toastMessage by mutableStateOf<String?>(null)

    var flagOnCreate by mutableStateOf(false)
    var colorOnCreate by mutableStateOf(Color.Transparent)
    var textColorOnCreate by mutableStateOf(Color.Black)

    var flagOnStart by mutableStateOf(false)
    var colorOnStart by mutableStateOf(Color.Transparent)
    var textColorOnStart by mutableStateOf(Color.Black)

    var flagOnResume by mutableStateOf(false)
    var colorOnResume by mutableStateOf(Color.Transparent)
    var textColorOnResume by mutableStateOf(Color.Black)

    var flagOnPause by mutableStateOf(false)
    var colorOnPause by mutableStateOf(Color.Transparent)
    var textColorOnPause by mutableStateOf(Color.Black)

    var flagOnStop by mutableStateOf(false)
    var colorOnStop by mutableStateOf(Color.Transparent)
    var textColorOnStop by mutableStateOf(Color.Black)

    var flagOnDestroy by mutableStateOf(false)
    var colorOnDestroy by mutableStateOf(Color.Transparent)
    var textColorOnDestroy by mutableStateOf(Color.Black)


    override fun onCreate(owner: LifecycleOwner){
        super.onCreate(owner)
        flagOnCreate = true
        colorOnCreate = Color.Blue
        textColorOnCreate = Color.White
        toastMessage = "onCreate"
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onCreate:")
    }

    override fun onStart(owner: LifecycleOwner) {
        flagOnStart = true
        colorOnStart = Color.Blue
        textColorOnStart = Color.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onStart()")
    }

    override fun onResume(owner: LifecycleOwner) {
        flagOnResume = true
        colorOnResume = Color.Blue
        textColorOnResume = Color.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onResume()")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        flagOnPause = true
        colorOnPause = Color.Blue
        textColorOnPause = Color.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onPause()")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        flagOnStop= true
        colorOnStop = Color.Red
        textColorOnStop = Color.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onStop()")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        flagOnDestroy= true
        colorOnDestroy = Color.Red
        textColorOnDestroy = Color.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onDestroy()")
    }
}