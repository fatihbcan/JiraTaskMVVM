package com.example.jirataskmvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jirataskmvvm.viewModel.CityRmViewModel
import com.example.jirataskmvvm.viewModel.EventListViewModel
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(CityRmViewModel::class)
    abstract fun bindCityRmViewModel(viewModel: CityRmViewModel?): ViewModel?


    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    abstract fun bindEventListViewModel(viewModel: EventListViewModel?): ViewModel?


}