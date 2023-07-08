package com.megamovies.moviessearch

import Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.moviessearch.DetailsFragment
import com.example.moviessearch.FilmListRecyclerAdapter
import com.example.moviessearch.HomeFragment
import com.megamovies.moviessearch.databinding.ActivityMainBinding

//import com.megamovies.moviessearch.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        supportFragmentManager.beginTransaction().add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(
                null
            ).commit()

        //находим наш RV
//        filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
//            override fun click(film: Film) {
//                (requireActivity() as MainActivity).launchDetailsFragment(film)
//            }
//        })

//        binding.mainRecycler.apply {
//            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
//            //оставим его пока пустым, он нам понадобится во второй части задания
//            filmsAdapter =
//                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
//                    override fun click(film: Film) {
////                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
////                        startActivity(intent)
//                        //Создаем бандл и кладем туда объект с данными фильма
//                        val bundle = Bundle()
//                        //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
//                        //передаваемый объект
//                        bundle.putParcelable("film", film)
//                        //Запускаем наше активити
//                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//                        //Прикрепляем бандл к интенту
//                        intent.putExtras(bundle)
//                        //Запускаем активити через интент
//                        startActivity(intent)
//                    }
//                })
//            //Присваиваем адаптер
//            adapter = filmsAdapter
//            //Присвои layoutmanager
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            //Применяем декоратор для отступов
//            val decorator = TopSpacingItemDecoration(8)
//            addItemDecoration(decorator)
//        }
////Кладем нашу БД в RV
//        filmsAdapter.addItems(filmsDataBase)
//

    }

    fun launchDetailFragment(film: Film) {
        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment)
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

//        binding.bottomNavigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.favorites -> {
//                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
//                    true
//                }
//
//                R.id.watch_later -> {
//                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
//                    true
//                }
//
//                R.id.selections -> {
//                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
//                    true
//                }
//
//                else -> {
//                    false
//                }
//            }
//        }
    }
}
