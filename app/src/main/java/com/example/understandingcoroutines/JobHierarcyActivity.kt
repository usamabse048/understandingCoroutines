package com.example.understandingcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.understandingcoroutines.databinding.ActivityJobHierarcyBinding
import kotlinx.coroutines.*

class JobHierarcyActivity : AppCompatActivity() {
    private var _binding: ActivityJobHierarcyBinding? = null
    private val binding get() = _binding!!
    private var instaViews:Deferred<Int>?= null
    private var fbViews:Deferred<Int>? = null
    private  var twitterViews:Deferred<Int>? = null


    override fun onStart() {
        Log.d("msg:: ","Activity Started")
        super.onStart()
    }

    override fun onResume() {
        Log.d("msg:: ","Activity Resumed")
        super.onResume()
    }

    override fun onPause() {
        Log.d("msg:: ","Activity Paused")
        super.onPause()
    }

    override fun onStop() {
        Log.d("msg:: ","Activity Stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("msg:: ","Activity Destroyed")
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(Observer())

        Log.d("msg:: ","Activity Created")
        super.onCreate(savedInstanceState)

        _binding = ActivityJobHierarcyBinding.inflate(layoutInflater)

        binding.apply {
            hierarcyCoroutineButton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    printViewsOfAllAccounts()
                    hierarcyTestTextView.text = "fb:${fbViews?.await()} insta:${instaViews?.await()} twitter:${twitterViews?.await()}"
                }

            }


        }
        setContentView(binding.root)
    }

    private suspend fun printViewsOfAllAccounts() {

        fbViews = CoroutineScope(Dispatchers.Main).async {
              getFbViews()
        }
        instaViews =  CoroutineScope(Dispatchers.Main).async {
            getInstaViews()
        }
        twitterViews = CoroutineScope(Dispatchers.Main).async {
       getTwitterViews()
        }




    }

    private suspend fun getFbViews(): Int {


        delay(2000)
        return 30


    }

    private suspend fun getInstaViews(): Int {
        delay(1000)
        return 400

    }

    private suspend fun getTwitterViews(): Int {
        delay(1000)
        return 100

    }
}