package com.megamovies.moviessearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.moviessearch.MainFragment1
import com.example.moviessearch.MainFragment2
import com.example.moviessearch.TestActivity1

import com.megamovies.moviessearch.databinding.ActivityMainBinding
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (MainFragment1.newInstance().isResumed) {
            val toast = Toast.makeText(applicationContext, "Resumed Frag1", Toast.LENGTH_LONG)
            toast.show()
        }
            binding.fragmentChanger.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_fragment_holder, MainFragment1.newInstance())
                    .commit()
            }


//        if (MainFragment2.newInstance().isResumed) {
//            binding.fragmentChanger.setOnClickListener {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.place_fragment_holder, MainFragment2.newInstance())
//                    .commit()
//            }
//        }

        binding.button.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(applicationContext, "Started", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(applicationContext, "Resumed", Toast.LENGTH_LONG)
        toast.show()
    }

//    fun onClickGoTest(view: View) {
//        val intent = Intent(this, TestActivity1::class.java)
//        startActivity(intent)
//    }


}


