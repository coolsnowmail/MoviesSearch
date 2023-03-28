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
//        binding.topAppBar.navigationIconTin
//        binding.appCompatButton2?.setOnClickListener {
//            Toast.makeText(
//                this,
//                "ЧИН ЧИНАРЕМ",
//                Toast.LENGTH_SHORT
//            ).show()
//        }

        //viewBinding
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root) // we now set the contentview as the binding.root
//        binding.button.setOnClickListener()
//        binding.button.text = "Hallo and welcome"
    }
    // default method
//    fun onClickToast(view: View) {
//        Toast.makeText(this, "chin", Toast.LENGTH_SHORT).show()
//    }
    // default method don't forget to add onClick attribute on button or whatever
}