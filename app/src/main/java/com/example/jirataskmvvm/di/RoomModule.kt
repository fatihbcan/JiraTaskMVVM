package com.example.jirataskmvvm.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.Room.dao.CityDao
import com.example.jirataskmvvm.Room.dao.EventsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): EventsDatabase {
        return Room
            .databaseBuilder(application, EventsDatabase::class.java, "event_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCityDao(@NonNull database: EventsDatabase): CityDao {
        return database.cityDao()
    }

    @Provides
    @Singleton
    fun provideEventsDao(@NonNull database: EventsDatabase): EventsDao {
        return database.eventDao()
    }

}