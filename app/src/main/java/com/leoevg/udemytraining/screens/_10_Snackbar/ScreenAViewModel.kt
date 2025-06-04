package com.leoevg.udemytraining.screens._10_Snackbar

import android.R.attr.action
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ScreenAViewModel: ViewModel() {
    fun showSnackbar(){
        viewModelScope.launch {
            SnackBarController.sendEvent(
                event = SnackbarEvent(
                    message = "Hello from ViewModel",
                    action = SnackBarAction(
                        name = "Click me!",
                        action = {
                            // просто защита от утечек
                            SnackBarController.sendEvent(
                                event = SnackbarEvent(
                                    message = "Action pressed!"
                                )
                            )
                        }
                    )
                )
            )
        }
    }
}