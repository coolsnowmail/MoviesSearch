package com.example.moviessearch.di

import com.example.moviessearch.di.modules.DatabaseModule
import com.example.moviessearch.di.modules.DomainModule
import com.example.moviessearch.di.modules.RemoteModule
import com.example.moviessearch.view.fragments.DetailsFragment
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import dagger.Component

@Component(modules = [RemoteModule::class, DatabaseModule::class, DomainModule::class])
interface AppComponent {

    fun inject(homeFragmentViewModel: HomeFragmentViewModel)

    fun inject(detailsFragment: DetailsFragment)
}