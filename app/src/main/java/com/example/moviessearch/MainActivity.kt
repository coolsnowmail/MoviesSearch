package com.megamovies.moviessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.makeText
import com.megamovies.moviessearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonInit()
    }

    private fun buttonInit() {
        binding.button1?.setOnClickListener{makeText(this, binding.button1.text, Toast.LENGTH_SHORT).show()}
        binding.button2?.setOnClickListener{makeText(this, binding.button2.text, Toast.LENGTH_SHORT).show()}
        binding.button3?.setOnClickListener{makeText(this, binding.button3.text, Toast.LENGTH_SHORT).show()}
        binding.button4?.setOnClickListener{makeText(this, binding.button4.text, Toast.LENGTH_SHORT).show()}
        binding.button5?.setOnClickListener{makeText(this, binding.button5.text, Toast.LENGTH_SHORT).show()}
    }
}
