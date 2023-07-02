package com.megamovies.moviessearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.makeText
import com.example.moviessearch.Film
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
        R.drawable.rill_bill,
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        supportActionBar?.title = "MoviesSearcher"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()

//        buttonInit()
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

//    private fun buttonInit() {
//        binding.button1?.setOnClickListener {
//            makeText(
//                this,
//                binding.button1.text,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        binding.button2?.setOnClickListener {
//            makeText(
//                this,
//                binding.button2.text,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        binding.button3?.setOnClickListener {
//            makeText(
//                this,
//                binding.button3.text,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        binding.button4?.setOnClickListener {
//            makeText(
//                this,
//                binding.button4.text,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        binding.button5?.setOnClickListener {
//            makeText(
//                this,
//                binding.button5.text,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
}
