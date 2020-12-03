package com.example.jirataskmvvm.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.Room.dao.CityDao
import com.example.jirataskmvvm.Room.dao.EventsDao
import com.example.jirataskmvvm.Room.repo.CityRoomRepository
import com.example.jirataskmvvm.Room.repo.EventsRoomRepository
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelsModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): EventsDatabase {
        return Room
            .databaseBuilder(application, EventsDatabase::class.java, "event_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://backend.etkinlik.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCityDao(@NonNull database: EventsDatabase): CityDao {
        return database.cityDao()
    }

    @Provides
    @Singleton
    fun provideEventDao(@NonNull database: EventsDatabase): EventsDao {
        return database.eventDao()
    }

    @Provides
    @Singleton
    fun provideCityRoomRepository(
        cityDao: CityDao,
        eventsDao: EventsDao,
        cityRepository: CityRepository,
        eventListRepository: EventListRepository,
        application: Application
    ): CityRoomRepository {
        return CityRoomRepository(
            cityDao,
            eventsDao,
            cityRepository,
            eventListRepository,
            application
        )
    }

    @Provides
    @Singleton
    fun provideEventRoomRepository(@NonNull eventsDao: EventsDao): EventsRoomRepository {
        return EventsRoomRepository(eventsDao)
    }

    @Provides
    @Singleton
    fun provideCityRepository(): CityRepository {
        return CityRepository()
    }

    @Provides
    @Singleton
    fun provideEventsRepository(): EventListRepository {
        return EventListRepository()
    }


}




