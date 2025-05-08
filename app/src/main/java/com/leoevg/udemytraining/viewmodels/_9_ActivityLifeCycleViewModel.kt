package com.leoevg.udemytraining.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

class _9_ActivityLifeCycleViewModel: ViewModel(), LifecycleObserver{
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

    fun onCreateEvent(){
        flagOnCreate = true
        colorOnCreate = Color.Blue
        textColorOnCreate = Color.White
    }

    fun onStartEvent(){
        flagOnStart = true
        colorOnStart = Color.Blue
        textColorOnStart = Color.White
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent() {
        flagOnResume = true
        colorOnResume = Color.Blue
        textColorOnResume = Color.White
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent(){
        flagOnPause = true
        colorOnPause = Color.Blue
        textColorOnPause = Color.White
    }



}