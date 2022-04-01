package com.example.understandingcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.understandingcoroutines.databinding.ActivityViewModel1Binding

class ViewModelActivity1 : AppCompatActivity() {
    private var _binding: ActivityViewModel1Binding? = null
    private val binding get() = _binding!!
   private lateinit var firstViewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstViewModel = ViewModelProvider(this,FirstViewModelFactory(counter = 12)).get(FirstViewModel::class.java)
        _binding = ActivityViewModel1Binding.inflate(layoutInflater)

        binding.apply {

            newCounterTextView.text= firstViewModel.getCounterValAsString()
            newCounterAddButton.setOnClickListener {
                firstViewModel.increment()
                newCounterTextView.text= firstViewModel.getCounterValAsString()

            }

        }
        setContentView(binding.root)
    }


}