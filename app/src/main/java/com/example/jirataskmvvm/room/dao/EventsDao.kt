package com.example.jirataskmvvm.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jirataskmvvm.room.entity.EventsRm

@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(eventsRm: EventsRm)

    @Query("SELECT * FROM events_table WHERE cityId == :cityId or cityId == 99 ORDER BY eId ASC")
    fun readAllEvents(cityId : Int): LiveData<List<EventsRm>>

}