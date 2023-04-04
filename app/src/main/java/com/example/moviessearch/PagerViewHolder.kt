package com.example.moviessearch

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import com.megamovies.moviessearch.databinding.ItemBinding


class PagerViewHolder(private val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
    fun onBind(item: PagerItem) {
        //корневой элемент item.xml
        itemBinding.container.setBackgroundColor(item.color)
        //Текстовое поле
        itemBinding.textView.text = item.text
    }


}