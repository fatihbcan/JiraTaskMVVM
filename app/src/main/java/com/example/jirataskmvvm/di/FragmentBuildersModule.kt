package com.example.jirataskmvvm.di

import com.example.jirataskmvvm.view.cityListFragment.CityListFragment
import com.example.jirataskmvvm.view.eventListFragment.EventListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeCitySelectionPage(): CityListFragment?

    @ContributesAndroidInjector
    abstract fun contributeEventListPage(): EventListFragment?

}