package com.example.jirataskmvvm.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.EventsRoom
import javax.inject.Inject


class EventsRoomRepository @Inject constructor(private val eventsDao: EventsDao) {


    // Gets events for spesific city
    fun getEvents(cityId: Int): LiveData<List<EventsRoom>> {
        return liveData {
            val data = eventsDao.readAllEvents(cityId)
            emitSource(data)
        }
    }


}