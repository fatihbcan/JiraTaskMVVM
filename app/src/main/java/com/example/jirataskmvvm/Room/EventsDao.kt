package com.example.jirataskmvvm.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(eventsRm: EventsRm)

    @Query("SELECT * FROM events_table WHERE cityId == :cityId or cityId == 99 ORDER BY eId ASC")
    suspend fun readAllEvents(cityId : Int): List<EventsRm>

    @Query("SELECT * FROM events_table WHERE eId == :eventId")
    suspend fun readEvent(eventId : Int): EventsRm

}