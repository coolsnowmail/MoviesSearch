package com.example.moviessearch.utils

import com.example.moviessearch.data.internet.Country

object ConvertContriesToString {
    fun convert(list: List<Country>): String {
        var result = ""
        list?.forEach {
            result += it.country + ". "
        }
        return result
    }
}