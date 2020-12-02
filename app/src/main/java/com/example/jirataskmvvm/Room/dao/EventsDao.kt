package com.example.jirataskmvvm.Room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jirataskmvvm.Room.entity.EventsRm

@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(eventsRm: EventsRm)

    @Query("SELECT * FROM events_table WHERE cityId == :cityId or cityId == 99 ORDER BY eId ASC")
    suspend fun readAllEvents(cityId : Int): List<EventsRm>

}