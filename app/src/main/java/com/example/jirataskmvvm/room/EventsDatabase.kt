package com.example.jirataskmvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jirataskmvvm.room.dao.CityDao
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.room.entity.EventsRoom

@Database(entities = [CityRoom::class, EventsRoom::class], version = 1, exportSchema = false)
abstract class EventsDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao
    abstract fun eventDao(): EventsDao

}