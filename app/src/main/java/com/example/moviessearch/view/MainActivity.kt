package com.example.moviessearch.view

import com.example.moviessearch.domain.Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestBuilder
import com.example.moviessearch.*
import com.example.moviessearch.view.fragments.*
import com.google.gson.Gson
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import okhttp3.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        supportFragmentManager.beginTransaction().add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(
                null
            ).commit()
    }

    var backPressed = 0L

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, "Doble tab for exit", Toast.LENGTH_SHORT).show()
            }

            backPressed = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }

    }

    companion object {
        const val TIME_INTERVAL = 2000
    }

    fun launchDetailsFragment(film: Film) {

        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null).commit()
    }

    private fun checkFragmentExistence(tag: String): Fragment? =
        supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    private fun initNavigation() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: HomeFragment(), tag)
                    true
                }

                R.id.favorites -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: FavoritesFragment(), tag)
                    true
                }

                R.id.watch_later -> {
                    val tag = "watch_later"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: SeeLaterFragment(), tag)
                    true
                }

                R.id.selections -> {
                    val tag = "selections"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: CollectionsFragment(), tag)
                    true
                }

                else -> false
            }
        }
    }
}


