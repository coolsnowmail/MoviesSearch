package com.megamovies.moviessearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviessearch.MainAdaptor
import com.example.moviessearch.TaskList
import com.megamovies.moviessearch.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main) // default method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MainAdaptor(TaskList.taskList)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        binding.recyclerView.setLayoutManager(layoutManager)
//        val recyclerView = findViewById < RecyclerView > (R.id.recycler_view)
//        recyclerView.layoutManager = GridLayoutManager(this, 5)
    }

}