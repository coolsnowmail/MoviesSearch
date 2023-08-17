package com.megamovies.moviessearch


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var diffX = 0f
    private var diffY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Fling"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val springForce = SpringForce(0f).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
        }
        val spring_view = binding.flingView
        val springAnimationX =
            SpringAnimation(spring_view, DynamicAnimation.TRANSLATION_X).setSpring(springForce)
        val springAnimationY =
            SpringAnimation(spring_view, DynamicAnimation.TRANSLATION_Y).setSpring(springForce)

        spring_view.setOnTouchListener { v, event ->
            v.performClick()
            //Проверяем какое действие у нас произошло
            when(event.action) {
                //MotionEvent.ACTION_DOWN - вызывается, когда ваш палец коснулся экрана, то есть как бы опустился
                //вниз, поэтому и DOWN
                MotionEvent.ACTION_DOWN -> {
                    //Устанавливаем координаты для корректного перемещения
                    diffX = event.rawX - v.x
                    diffY = event.rawY - v.y

                    //Отменяем анимацию, если к примера нашу view еще "пружинит" с предыдущего раза
                    springAnimationX.cancel()
                    springAnimationY.cancel()
                }
                //MotionEvent.ACTION_MOVE - вызывается, когда мы перемещаем view, то есть меняются координаты
                //view
                MotionEvent.ACTION_MOVE -> {
                    //rawX, rawY текущие координаты view
                    spring_view.x = event.rawX - diffX
                    spring_view.y = event.rawY - diffY
                }
                //MotionEvent.ACTION_UP - вызывается, когда палец перестал касаться экрана
                MotionEvent.ACTION_UP -> {
                    //Стартуем анимацию возвращения в прежнее положение
                    springAnimationX.start()
                    springAnimationY.start()
                }
            }
            true
        }

    }
}


