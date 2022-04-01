package com.example.understandingcoroutines

import android.util.Log
import androidx.lifecycle.*


class Observer: DefaultLifecycleObserver {


    override fun onCreate(owner: LifecycleOwner) {

        super.onCreate(owner)
        Log.d("msg:: ", "Observer onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("msg:: ", "Observer onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("msg:: ", "Observer onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("msg:: ", "Observer onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("msg:: ", "Observer onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("msg:: ", "Observer onDestroy")
    }


}