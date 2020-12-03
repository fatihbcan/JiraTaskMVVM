package com.example.jirataskmvvm.di

import androidx.lifecycle.ViewModelProvider
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory

import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {


    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}