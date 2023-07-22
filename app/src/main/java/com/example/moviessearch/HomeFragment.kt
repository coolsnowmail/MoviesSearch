package com.example.moviessearch

import Film
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.megamovies.moviessearch.MainActivity
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentHomeBinding
import java.util.Locale


val filmsDataBase = listOf(
    Film(
        "Dark Knight",
        R.drawable.dark_knight,
        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
    ),
    Film(
        "Back Dragt",
        R.drawable.backdraft,
        "Two Chicago firefighter brothers, who don't get along, have to work together while a dangerous arsonist is on the loose.",
        isFavorites = true
    ),
    Film(
        "Scarface",
        R.drawable.scarface,
        "In 1980 Miami, a determined Cuban immigrant takes over a drug cartel and succumbs to greed."
    ),
    Film(
        "Batman",
        R.drawable.batman,
        "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement."
    ),
    Film(
        "Godfather",
        R.drawable.godfather,
        "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."
    ),
    Film(
        "Kill Bill",
        R.drawable.kill_bill,
        "After awakening from a four-year coma, a former assassin wreaks vengeance on the team of assassins who betrayed her."
    ),
    Film(
        "Reservoir dogs",
        R.drawable.reservoir_dogs,
        "When a simple jewelry heist goes horribly wrong, the surviving criminals begin to suspect that one of them is a police informant."
    ),
    Film(
        "Marlin",
        R.drawable.jaz_girls_only,
        "Documentary about the moviestar's last months including her tumultuous love affairs, drug and alcohol dependency, depression and eventual firing from her final film, 20th Century Fox's \"Something's Got To Give\". Features several first time interviews with the people surrounding Monroe at the end of her life, behind the scenes footage and stills, and the assembled footage from her final film, co-starring Dean Martin and Cyd Charisse."
    ),
    Film(
        "Austin Powers",
        R.drawable.austin_powers_in_goldmember,
        "Upon learning that his father has been kidnapped, Austin Powers must travel to 1975 and defeat the aptly named villain Goldmember, who is working with Dr. Evil."
    ),
)

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
        binding.searchView.setOnClickListener {
//            Toast.makeText(activity, "fsjfgjfgiofs", Toast.LENGTH_SHORT).show()
            binding.searchView.isIconified = false
        }


//Подключаем слушателя изменений введенного текста в поиска
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText != null) {
                    if (newText.isEmpty()) {
                        filmsAdapter.addItems(filmsDataBase)
                        return true
                    }
                    val result = filmsDataBase.filter {
                        it.title?.contains(newText, ignoreCase = true) ?: false
                    }
                    filmsAdapter.addItems(result)
                }
                return true
            }
        })

        return binding.root


    }
}


