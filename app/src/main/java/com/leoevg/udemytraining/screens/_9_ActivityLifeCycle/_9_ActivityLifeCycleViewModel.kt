package com.leoevg.udemytraining.screens._9_ActivityLifeCycle

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
    var colorOnCreate by mutableStateOf(Color.Companion.Transparent)
    var textColorOnCreate by mutableStateOf(Color.Companion.Black)

    var flagOnStart by mutableStateOf(false)
    var colorOnStart by mutableStateOf(Color.Companion.Transparent)
    var textColorOnStart by mutableStateOf(Color.Companion.Black)

    var flagOnResume by mutableStateOf(false)
    var colorOnResume by mutableStateOf(Color.Companion.Transparent)
    var textColorOnResume by mutableStateOf(Color.Companion.Black)

    var flagOnPause by mutableStateOf(false)
    var colorOnPause by mutableStateOf(Color.Companion.Transparent)
    var textColorOnPause by mutableStateOf(Color.Companion.Black)

    var flagOnStop by mutableStateOf(false)
    var colorOnStop by mutableStateOf(Color.Companion.Transparent)
    var textColorOnStop by mutableStateOf(Color.Companion.Black)

    var flagOnDestroy by mutableStateOf(false)
    var colorOnDestroy by mutableStateOf(Color.Companion.Transparent)
    var textColorOnDestroy by mutableStateOf(Color.Companion.Black)


    override fun onCreate(owner: LifecycleOwner){
        super.onCreate(owner)
        flagOnCreate = true
        colorOnCreate = Color.Companion.Blue
        textColorOnCreate = Color.Companion.White
        toastMessage = "onCreate"
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onCreate:")
    }

    override fun onStart(owner: LifecycleOwner) {
        flagOnStart = true
        colorOnStart = Color.Companion.Blue
        textColorOnStart = Color.Companion.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onStart()")
    }

    override fun onResume(owner: LifecycleOwner) {
        flagOnResume = true
        colorOnResume = Color.Companion.Blue
        textColorOnResume = Color.Companion.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onResume()")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        flagOnPause = true
        colorOnPause = Color.Companion.Blue
        textColorOnPause = Color.Companion.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onPause()")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        flagOnStop= true
        colorOnStop = Color.Companion.Red
        textColorOnStop = Color.Companion.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onStop()")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        flagOnDestroy= true
        colorOnDestroy = Color.Companion.Red
        textColorOnDestroy = Color.Companion.White
        Log.i("!!!", "${this::class.simpleName} Выполняется метод onDestroy()")
    }
}