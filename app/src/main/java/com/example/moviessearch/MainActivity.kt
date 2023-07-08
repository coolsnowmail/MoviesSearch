package com.megamovies.moviessearch

import Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.moviessearch.DetailsFragment
import com.example.moviessearch.FilmListRecyclerAdapter
import com.example.moviessearch.HomeFragment
import com.megamovies.moviessearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        initNavigation()
        supportFragmentManager.beginTransaction().add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(
                null
            ).commit()


    }

    fun launchDetailsFragment(film: Film) {

        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null).commit()
    }
}


