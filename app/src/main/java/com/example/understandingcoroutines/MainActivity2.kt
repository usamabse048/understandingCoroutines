package com.example.understandingcoroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.*
import kotlin.math.log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         CoroutineScope(Dispatchers.IO).launch {


           getNumberOfAllUsers()

        }

    }

    private suspend fun getNumberOfAllUsers() {
        var users = 0

        CoroutineScope(Dispatchers.IO).launch {
            users = allUsers()
        }

        Log.d("m","$users")

    }

    private suspend fun allUsers() : Int {
        delay(10000)
        return 55

    }


}