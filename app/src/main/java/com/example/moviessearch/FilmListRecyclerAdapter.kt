package com.example.moviessearch

import Film
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.megamovies.moviessearch.databinding.FilmItemBinding

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FilmViewHolder(private val itemFilmBinding: FilmItemBinding) :
        RecyclerView.ViewHolder(itemFilmBinding.root) {
        fun bind(film: Film) {
            itemFilmBinding.title.text = film.title
            itemFilmBinding.description.text = film.description
            itemFilmBinding.poster.setImageResource(film.poster)
        }
    }
    private val items = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(
            FilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                //Вызываем метод bind(), который мы создали, и передаем туда объект
                //из нашей базы данных с указанием позиции
                holder.bind(items[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //например, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера
                holder.itemView.setOnClickListener {
                    clickListener.click(items[position])
                }
            }
        }
    }

    //Метод для добавления объектов в наш список
    fun addItems(list: List<Film>) {
        //Сначала очищаем(если не реализовать DiffUtils)
        items.clear()
        //Добавляем
        items.addAll(list)
        //Уведомляем RV, что пришел новый список, и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }


    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(film: Film)
    }

}