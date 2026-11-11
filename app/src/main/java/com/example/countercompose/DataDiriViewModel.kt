package com.example.countercompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DataDiriViewModel : ViewModel() {

    var nama by mutableStateOf("")
        private set

    var umur by mutableStateOf("")
        private set

    fun onNamaChange(value: String) {
        nama = value
    }

    fun onUmurChange(value: String) {
        if (value.length <= 3 && value.all { it.isDigit() }) {
            umur = value
        }
    }
}
