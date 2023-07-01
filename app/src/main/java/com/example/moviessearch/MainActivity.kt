package com.megamovies.moviessearch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import com.megamovies.moviessearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val snackbar = Snackbar.make(binding.mainLayout, "SnackBar", Snackbar.LENGTH_INDEFINITE)
        binding.fab.setOnClickListener {
            snackbar.show()
        }


        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
           if(verticalOffset == 0) {
               binding.toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.black))
           }
            if (verticalOffset == appBarLayout.scrollBarSize) {
               binding.toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, androidx.appcompat.R.color.abc_secondary_text_material_dark))

            }
            binding.toolbarLayout.title = verticalOffset.toString()
        })


    }
}