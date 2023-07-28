package com.megamovies.moviessearch

import Film
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.transition.Scene
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import com.example.moviessearch.*
import com.megamovies.moviessearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.exitTransition = Slide(Gravity.START).apply {
            mode = Slide.MODE_OUT;
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        // 3) setup reenterTransition
        window.reenterTransition = Slide(Gravity.START).apply {
            duration = 1000;
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        binding.butfrst.setOnClickListener {
            // 4) create activityOptions
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            startActivity(Intent(this, SecActivity::class.java), activityOptions.toBundle())
        }


//        val scene1 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene1, this)
//        val scene2 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene2, this)
//
//        val transitionManager = TransitionManager()
//        scene1.setEnterAction{
//            val button = findViewById<Button>(R.id.button)
//            button.setOnClickListener {
//                transitionManager.transitionTo(scene2)
//            }
//        }
//        scene2.setEnterAction{
//            val button = findViewById<Button>(R.id.button)
//            button.setOnClickListener {
//                transitionManager.transitionTo(scene1)
//            }
//        }
//        transitionManager.transitionTo(scene1)
//

//        val transitionManager = TransitionInflater.from(this)
//            .inflateTransitionManager(R.transition.t_manager, binding.sceneRoot);
//        transitionManager.transitionTo(scene1)
//        val button = findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//            transitionManager.transitionTo(scene2)
//            if (transitionManager.) {
//                transitionManager.transitionTo(scene1)
//            }
//        }

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

    private fun initNavigation() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_placeholder, FavoritesFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
}


