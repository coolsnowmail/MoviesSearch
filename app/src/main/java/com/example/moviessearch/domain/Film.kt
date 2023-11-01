package com.example.moviessearch.domain


import android.os.Parcel
import android.os.Parcelable
import com.example.moviessearch.data.internet.Country
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Film(
    val id: Int,
    val title: String?,
    val year: Int?,
    val poster: String?,
    var description: String? = null,
    var rating: Double = 0.0,
    var isInFavorites: Boolean = false,
    @IgnoredOnParcel
    val countries: List<Country>
) : Parcelable


