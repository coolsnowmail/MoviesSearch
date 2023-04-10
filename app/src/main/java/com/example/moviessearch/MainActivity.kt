package com.megamovies.moviessearch

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
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

        val sunAnim = ObjectAnimator.ofFloat(binding.sun, View.TRANSLATION_Y, -1000f)
        sunAnim.duration = 3000

        val sunRizeAnim = ObjectAnimator.ofFloat(binding.sunrize, View.ALPHA, 0F, 1F)
        sunRizeAnim.duration = 4000

        val cloudyAnim = ObjectAnimator.ofFloat(binding.sunrize, View.ALPHA, 1F, 0.7F)
        sunRizeAnim.duration = 10

        val cloud1 = ObjectAnimator.ofFloat(binding.leftCloud, View.TRANSLATION_X, 600f)
        cloud1.duration = 2000

        val cloud2 = ObjectAnimator.ofFloat(binding.rightCloud, View.TRANSLATION_X, -700f)
        cloud2.duration = 3000

        val animatorSun = AnimatorSet()
        animatorSun.playTogether(sunAnim, sunRizeAnim)

        animatorSun.play(cloud1).after(500)
        animatorSun.play(cloud2).after(500)
        animatorSun.play(cloudyAnim).after(cloud2)

        animatorSun.start()


    }
}