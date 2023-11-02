package com.example.moviessearch.domain


import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String?,
    val year: Int?,
    val poster: String?,
    val description: String? = null,
    var rating: Double = 0.0,
    var isInFavorites: Boolean = false
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    companion object : Parceler<Film> {

        override fun Film.write(parcel: Parcel, flags: Int) {
            parcel.writeString(title)
            parcel.writeValue(year)
            parcel.writeString(poster)
            parcel.writeString(description)
            parcel.writeDouble(rating)
            parcel.writeByte(if (isInFavorites) 1 else 0)
        }

        override fun create(parcel: Parcel): Film {
            return Film(parcel)
        }
    }
}


