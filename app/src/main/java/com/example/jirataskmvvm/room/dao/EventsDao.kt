package com.example.jirataskmvvm.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jirataskmvvm.room.entity.EventsRoom

@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(eventsRoom: EventsRoom)

    @Query("SELECT * FROM events_table WHERE cityId == :cityId or cityId == 99 ORDER BY name ASC")
    fun readAllEvents(cityId: Int): LiveData<List<EventsRoom>>

}