package com.example.understandingcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FirstViewModelFactory(val counter:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

       return FirstViewModel(counter = counter) as T
    }

}