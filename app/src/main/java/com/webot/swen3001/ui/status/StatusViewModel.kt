package com.webot.swen3001.ui.status

import android.util.Log
import androidx.lifecycle.ViewModel

class StatusViewModel : ViewModel() {
    init {
        Log.i("ProfileViewModel", "ProfileViewModel created!")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("ProfileViewModel", "ProfileViewModel destroyed!")
    }
}