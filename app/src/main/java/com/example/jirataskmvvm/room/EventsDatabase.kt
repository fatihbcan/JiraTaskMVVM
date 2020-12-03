package com.example.jirataskmvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jirataskmvvm.room.dao.CityDao
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.CityRm
import com.example.jirataskmvvm.room.entity.EventsRm

@Database(entities = [CityRm::class, EventsRm::class], version = 1, exportSchema = false)
abstract class EventsDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao
    abstract fun eventDao(): EventsDao

   /* companion object {
        @Volatile
        private var INSTANCE: EventsDatabase? = null

        fun getEventsDatabase(context: Context): EventsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = room.databaseBuilder(
                    context.applicationContext,
                    EventsDatabase::class.java,
                    "event_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }*/
}