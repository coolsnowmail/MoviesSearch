package com.megamovies.moviessearch


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRevealed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonsContainer.visibility = View.GONE
        binding.fab.setOnClickListener {
            if (!isRevealed) {
                reveal()
            } else {
                hide()
            }
        }
    }

//    private fun reveal() {
//        val x: Int = binding.fab.x.roundToInt() + binding.fab.width / 2
//        val y: Int = binding.fab.y.roundToInt() + binding.fab.height / 2
//        val endRadius = hypot(
//            binding.buttonsContainer.width.toDouble(),
//            binding.buttonsContainer.height.toDouble()
//        )
//        val startRadus = 0
//        val anim = ViewAnimationUtils.createCircularReveal(
//            binding.buttonsContainer, x, y, startRadus.toFloat(),
//            endRadius.toFloat()
//        )
//        anim.duration = 1000
//        binding.buttonsContainer.visibility = View.VISIBLE
//        anim.start()
//        isRevealed = true
//    }

    private fun reveal() {
        val x: Int = binding.fab.x.roundToInt() + binding.fab.width / 2
        val y: Int = binding.fab.y.roundToInt() + binding.fab.height / 2

        val startRadius = 0
        binding.buttonsContainer
        val endRadius = hypot(binding.buttonsContainer.width.toDouble(), binding.buttonsContainer.height.toDouble())
        val anim = ViewAnimationUtils.createCircularReveal(binding.buttonsContainer, x, y, startRadius.toFloat(), endRadius.toFloat())
        anim.duration = 500
        binding.buttonsContainer.visibility = View.VISIBLE
        anim.start()
        isRevealed = true
    }


    private fun hide() {
        val x: Int = binding.fab.x.roundToInt() + binding.fab.width / 2
        val y: Int = binding.fab.y.roundToInt() + binding.fab.height / 2
        val startRadius: Int = binding.mainContainer.width.coerceAtLeast(binding.buttonsContainer.height)
        val endRadius = 0

        val anim = ViewAnimationUtils.createCircularReveal(binding.buttonsContainer, x, y, startRadius.toFloat(), endRadius.toFloat())
        anim.duration = 500

        //Слушатель конца анимации, когда анимация закончится, мы скроем View
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animator: Animator) {
                binding.buttonsContainer.visibility = View.GONE
            }
        })
        anim.start()
        isRevealed = false
    }
//    private fun hideButContainer() {
//        val x: Int = binding.fab.x.roundToInt() + binding.fab.width / 2
//        val y: Int = binding.fab.y.roundToInt() + binding.fab.height / 2
//        val startRadius: Int =
//            binding.mainContainer.width.coerceAtLeast(binding.buttonsContainer.height)
//
//
//        val endRadius = 0
//
//        val anim = ViewAnimationUtils.createCircularReveal(
//            binding.fab, x, y, startRadius.toFloat(),
//            endRadius.toFloat()
//        )
//        anim.addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator) {
//                binding.buttonsContainer.visibility = View.GONE
//            }
//        })
//        anim.duration = 1000
//        anim.start()
//        isRevealed = false
//    }
}


