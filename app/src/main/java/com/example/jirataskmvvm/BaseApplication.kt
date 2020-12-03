package com.example.jirataskmvvm

import android.app.Application
import com.example.jirataskmvvm.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class BaseApplication :DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return DaggerAppComponent.builder().application(this).build()
    }

}