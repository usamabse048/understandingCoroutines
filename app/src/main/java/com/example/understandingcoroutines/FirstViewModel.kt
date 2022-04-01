package com.example.understandingcoroutines

import androidx.lifecycle.ViewModel

class FirstViewModel(private var counter:Int) : ViewModel() {


    fun increment(){
        counter++
    }
    fun decrement(){
        if(counter!=0){
            counter--
        }
    }
    fun getCounterValAsString():String{
        return counter.toString()

    }
}