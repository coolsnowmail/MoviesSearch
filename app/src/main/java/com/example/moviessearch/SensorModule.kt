package com.example.moviessearch

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SensorModule {
    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasureSensors {
        return LightSensor(app)
    }
}