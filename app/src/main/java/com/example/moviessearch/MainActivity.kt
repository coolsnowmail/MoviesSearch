package com.megamovies.moviessearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.moviessearch.MainFragment1
import com.example.moviessearch.MainFragment2
import com.example.moviessearch.TestActivity1

import com.megamovies.moviessearch.databinding.ActivityMainBinding
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}


