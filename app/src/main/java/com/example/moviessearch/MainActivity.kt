package com.megamovies.moviessearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.moviessearch.TestActivity1

import com.megamovies.moviessearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(applicationContext, "Started", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(applicationContext, "Resumed", Toast.LENGTH_LONG)
        toast.show()
    }

//    fun onClickGoTest(view: View) {
//        val intent = Intent(this, TestActivity1::class.java)
//        startActivity(intent)
//    }


}


