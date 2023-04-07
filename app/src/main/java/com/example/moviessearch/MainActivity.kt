package com.megamovies.moviessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
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