package com.megamovies.moviessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import com.megamovies.moviessearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) // default method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar?.setNavigationOnClickListener {
            Toast.makeText(this, "Когда-нибудь здесь будет навигация...", Toast.LENGTH_SHORT).show()
        }
        binding.topAppBar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.fav -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Еще", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}