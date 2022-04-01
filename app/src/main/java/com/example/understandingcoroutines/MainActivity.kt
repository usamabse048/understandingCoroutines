package com.example.understandingcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.understandingcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var counter = 0
    private var users = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            counterView.text = users.toString()

            counterButton.setOnClickListener {
                counter++
                counterView.text = counter.toString()

            }
            lobgTaskButton.setOnClickListener {
                doLongTaskOnDiffThread()
            }
            coroutineTest.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    printNumberOfUsers()
                    counterView.text  = users.toString()
                }
            }
        }
        setContentView(binding.root)
    }

    private fun doLongTaskOnDiffThread() {
        thread {
            for (i in 1..1000000000L) {

            }
        }


    }

    private fun doLongTaskOnCoroutines() {

    }

    private fun longTask() {
        for (i in 1..1000000000L) {

        }

    }

    private suspend fun printNumberOfUsers(){
       var myUsers = 0
       val job =  CoroutineScope(Dispatchers.Main).launch {
            myUsers = getAllUsers()
        }
        job.join()
        users = myUsers
    }

    private suspend fun getAllUsers(): Int{
        delay(5000)
        return 33
    }

}