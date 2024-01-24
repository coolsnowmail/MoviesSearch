package com.example.moviessearch.di.modules

import com.example.moviessearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    fun provideRepository() = MainRepository()
}