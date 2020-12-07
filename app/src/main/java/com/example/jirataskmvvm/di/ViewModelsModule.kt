package com.example.jirataskmvvm.di

import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.viewModel.CityListViewModel
import com.example.jirataskmvvm.viewModel.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(CityListViewModel::class)
    abstract fun bindCityRmViewModel(viewModel: CityListViewModel?): ViewModel?


    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    abstract fun bindEventListViewModel(viewModel: EventListViewModel?): ViewModel?


}