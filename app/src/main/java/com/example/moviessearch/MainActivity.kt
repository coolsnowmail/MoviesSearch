package com.megamovies.moviessearch

import Film
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviessearch.BlankFragment
import com.example.moviessearch.BlankFragment2
import com.example.moviessearch.FilmListRecyclerAdapter
import com.example.moviessearch.TopSpacingItemDecoration
import com.megamovies.moviessearch.databinding.ActivityMainBinding

val filmsDataBase = listOf(
    Film(
        "Dark Knight",
        R.drawable.dark_knight,
        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
    ),
    Film(
        "Back Dragt",
        R.drawable.backdraft,
        "Two Chicago firefighter brothers, who don't get along, have to work together while a dangerous arsonist is on the loose."
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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()


        val tag = "fragment_1"
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, BlankFragment2(), tag)
            .addToBackStack(null)
            .commit()

//        supportFragmentManager.beginTransaction().replace(R.layout.fragment_blank, BlankFragment()).commit()

        //находим наш RV

        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
//                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//                        startActivity(intent)
                        //Создаем бандл и кладем туда объект с данными фильма
                        val bundle = Bundle()
                        //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                        //передаваемый объект
                        bundle.putParcelable("film", film)
                        //Запускаем наше активити
                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                        //Прикрепляем бандл к интенту
                        intent.putExtras(bundle)
                        //Запускаем активити через интент
                        startActivity(intent)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(this@MainActivity)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)


    }

    fun passData(editText: String) {
        val bundle = Bundle()
        bundle.putString("input", editText)

        val frag2 = BlankFragment2()
        frag2.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, frag2)
            .addToBackStack(null).commit()
    }

    private fun initNavigation() {
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}
