package com.megamovies.moviessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.megamovies.moviessearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val snackbar = Snackbar.make(binding.mainLayout, "Snackbar", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("action") {
            Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
        }
        snackbar.setActionTextColor(ContextCompat.getColor(this, androidx.appcompat.R.color.error_color_material_dark))
        binding.buttonGetSnack.setOnClickListener {
            snackbar.show()
        }
    }
}