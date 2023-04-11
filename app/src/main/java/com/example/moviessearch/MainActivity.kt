package com.megamovies.moviessearch

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.moviessearch.PagerItem
import com.example.moviessearch.ViewPagerAdapter
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import com.megamovies.moviessearch.databinding.ItemBinding
import kotlinx.coroutines.delay

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) // default method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.likeBut.setOnClickListener {

        }
    }
}