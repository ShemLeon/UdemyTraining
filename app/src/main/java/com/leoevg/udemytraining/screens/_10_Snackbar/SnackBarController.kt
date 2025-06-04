package com.leoevg.udemytraining.data

import android.os.Message
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

data class SnackbarEvent(
    val message: String,
    val action: SnackBarAction? = null
)

data class SnackBarAction{
    val name: String,
    val action: () -> Unit
}


object SnackBarController {
    private val _events = Channel<SnackbarEvent>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event: SnackbarEvent){
        _events.send(event)
    }
}