package com.example.moviessearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.megamovies.moviessearch.databinding.ItemBinding
import com.megamovies.moviessearch.databinding.RecycleViewItemBinding

class MainAdaptor(val taskList: List<Task>) : RecyclerView.Adapter<MainAdaptor.MainViewHolder>() {
    inner class MainViewHolder(val itemBinding: RecycleViewItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindingItem(task: Task) {
            itemBinding.title1.text = task.title
            itemBinding.title2.text = task.title2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecycleViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]
        holder.bindingItem(task)
    }
}