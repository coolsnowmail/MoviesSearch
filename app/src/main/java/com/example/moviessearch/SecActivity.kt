package com.example.moviessearch

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.widget.Button
import com.megamovies.moviessearch.MainActivity
import com.megamovies.moviessearch.R

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        // 2) allow overlaps
        window.allowEnterTransitionOverlap = true
        window.allowReturnTransitionOverlap = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        //Transition for SecondActivity
        // 3) setup enterTransition
        window.enterTransition = Fade().apply {
            duration = 1000;
            mode = Fade.MODE_IN
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        // 4) setup returnTransition
        window.returnTransition = Fade().apply {
            duration = 1000;
            mode = Fade.MODE_IN
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        val button = findViewById<Button>(R.id.butsec)
        button.setOnClickListener {
            onBackPressed()
        }
    }
}