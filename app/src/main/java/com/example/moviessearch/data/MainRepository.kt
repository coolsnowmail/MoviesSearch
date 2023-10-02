package com.example.moviessearch.data

import com.example.moviessearch.domain.Film
import com.megamovies.moviessearch.R

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            "Dark Knight",
            R.drawable.dark_knight,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            rating = 8F
        ),
        Film(
            "Back Dragt",
            R.drawable.backdraft,
            "Two Chicago firefighter brothers, who don't get along, have to work together while a dangerous arsonist is on the loose.",
            rating = 5.5f,
            isFavorites = true
        ),
        Film(
            "Scarface",
            R.drawable.scarface,
            "In 1980 Miami, a determined Cuban immigrant takes over a drug cartel and succumbs to greed.",
            rating = 6f
        ),
        Film(
            "Batman",
            R.drawable.batman,
            "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
            rating = 6f
        ),
        Film(
            "Godfather",
            R.drawable.godfather,
            "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
            rating = 7f
        ),
        Film(
            "Kill Bill",
            R.drawable.kill_bill,
            "After awakening from a four-year coma, a former assassin wreaks vengeance on the team of assassins who betrayed her.",
            rating = 8f
        ),
        Film(
            "Reservoir dogs",
            R.drawable.reservoir_dogs,
            "When a simple jewelry heist goes horribly wrong, the surviving criminals begin to suspect that one of them is a police informant.",
            rating = 6f
        ),
        Film(
            "Marlin",
            R.drawable.jaz_girls_only,
            "Documentary about the moviestar's last months including her tumultuous love affairs, drug and alcohol dependency, depression and eventual firing from her final film, 20th Century Fox's \"Something's Got To Give\". Features several first time interviews with the people surrounding Monroe at the end of her life, behind the scenes footage and stills, and the assembled footage from her final film, co-starring Dean Martin and Cyd Charisse.",
            rating = 9f
        ),
        Film(
            "Austin Powers",
            R.drawable.austin_powers_in_goldmember,
            "Upon learning that his father has been kidnapped, Austin Powers must travel to 1975 and defeat the aptly named villain Goldmember, who is working with Dr. Evil.",
            rating = 6f
        ),
    )
}