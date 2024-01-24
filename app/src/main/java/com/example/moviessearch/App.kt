package com.example.moviessearch

import android.app.Application
import com.example.moviessearch.di.AppComponent
//import com.example.moviessearch.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
//        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}