package com.leoevg.udemytraining.viewmodels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class _10_SnackBarViewModel: ViewModel() {
    var toastMessage by mutableStateOf<String?>(null)

}