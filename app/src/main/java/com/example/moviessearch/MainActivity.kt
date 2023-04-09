package com.megamovies.moviessearch

import android.animation.Animator
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

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) // default method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animationUpdateListener = object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationEnd(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationStart(animation: Animator) {
                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
                println("start")
            }
        }

        binding.button.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(binding.roket, View.TRANSLATION_Y, 0F, -1000F)
            anim.duration = 1000
            anim.addListener(animationUpdateListener)
            anim.start()
        }



//        val myAnimation = AnimationUtils.loadAnimation(this, R.anim.roket_anim)
//        binding.roket?.setOnClickListener{
//            binding.roket?.startAnimation(myAnimation)

//        }

        //Создаем адаптер
//        val pagerAdapter = ViewPagerAdapter()
//
//        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
//        binding.viewPager2?.adapter = pagerAdapter
//
//        //Создаем список элементов, который передадим в адаптер
//        val pagerItems = listOf<PagerItem>(
//            PagerItem(ContextCompat.getColor(this, R.color.black), "Red"),
//            PagerItem(ContextCompat.getColor(this, R.color.purple_500), "Green"),
//            PagerItem(ContextCompat.getColor(this, R.color.teal_700), "Yellow")
//        )
//
//        //Передаем список в адаптер
//        pagerAdapter.setItems(pagerItems)
    }
}