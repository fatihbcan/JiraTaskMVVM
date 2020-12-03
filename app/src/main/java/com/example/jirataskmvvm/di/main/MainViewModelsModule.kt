package com.example.jirataskmvvm.di.main

import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.di.ViewModelKey
import com.example.jirataskmvvm.viewModel.CityRmViewModel
import com.example.jirataskmvvm.viewModel.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/*@Module
abstract class MainViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(CityRmViewModel::class)
    abstract fun bindCityRmViewModel(viewModel: CityRmViewModel?): ViewModel?


    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    abstract fun bindEventListViewModel(viewModel: EventListViewModel?): ViewModel?
}*/