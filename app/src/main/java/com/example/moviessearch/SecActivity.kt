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
        //Transition for SecondActivity
        // 3) setup enterTransition
//        window.enterTransition = Fade().apply {
//            mode = Fade.MODE_IN
//            excludeTarget(android.R.id.statusBarBackground, true)
//            excludeTarget(android.R.id.navigationBarBackground, true)
//            excludeTarget(android.R.id.navigationBarBackground, true)
//            addListener(onStart = {
//                val slide = Slide()
//                val root = findViewById<ConstraintLayout>(R.id.sec_root)
//                val image = findViewById<ImageView>(R.id.image_view_android)
//                image.visibility = View.INVISIBLE
//                TransitionManager.beginDelayedTransition(root, slide)
//                image.visibility = View.VISIBLE
//            })
//        }
        window.enterTransition = Fade().apply {
            duration = 1000
            mode = Fade.MODE_IN
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
            addListener(onStart = {
                val slide = Slide()
                slide.duration = 2000
                val root = findViewById<ConstraintLayout>(R.id.sec_root)
                val image = findViewById<ImageView>(R.id.image_view_android)
                image.visibility = View.INVISIBLE
                TransitionManager.beginDelayedTransition(root, slide)
                image.visibility = View.VISIBLE

            })

        }
        // 4) setup returnTransition
        window.returnTransition = TransitionSet().apply {
            addTransition(Slide().apply {
                mode = Slide.MODE_OUT
                                val root = findViewById<ConstraintLayout>(R.id.sec_root)
                val image = findViewById<ImageView>(R.id.image_view_android)
                addTarget(image)
                removeTarget(root)
            })
            addTransition(Slide(Gravity.END).apply {
                mode = Slide.MODE_OUT;
                excludeTarget(android.R.id.statusBarBackground, true)
                excludeTarget(android.R.id.navigationBarBackground, true)
            })
            ordering = TransitionSet.ORDERING_TOGETHER
        }
        val button = findViewById<Button>(R.id.butsec)
        button.setOnClickListener {
            onBackPressed()
        }
    }
}