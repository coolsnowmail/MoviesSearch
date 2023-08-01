package com.example.moviessearch

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.transition.addListener
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
    }
}