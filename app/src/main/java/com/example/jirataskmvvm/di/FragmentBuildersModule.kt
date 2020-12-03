package com.example.jirataskmvvm.di

import com.example.jirataskmvvm.view.citySelectPage.citySelectionPage
import com.example.jirataskmvvm.view.eventListPage.EventListPage
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeCitySelectionPage(): citySelectionPage?
    @ContributesAndroidInjector
    abstract fun contributeEventListPage(): EventListPage?

}