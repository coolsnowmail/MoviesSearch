package com.megamovies.moviessearch


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Fling"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val flingX = FlingAnimation(binding.flingView, DynamicAnimation.X).apply {
            friction = 1.1f
        }
        val flingY = FlingAnimation(binding.flingView, DynamicAnimation.Y).apply {
            friction = 1.1f
        }
        val gestureListener = object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(
                e1: MotionEvent,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                flingX.setStartVelocity(velocityX)
                flingY.setStartVelocity(velocityY)

                flingX.start()
                flingY.start()

                return true
            }
        }

        val gestureDetector = GestureDetector(this, gestureListener)

        binding.flingView.setOnTouchListener { v, event ->
            v.performClick()
            gestureDetector.onTouchEvent(event)
        }
    }
}


