package com.example.jirataskmvvm.Room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.Room.dao.EventsDao
import com.example.jirataskmvvm.Room.entity.EventsRm
import javax.inject.Inject

class EventsRoomRepository @Inject constructor(private val eventsDao: EventsDao) {

    fun getEvents(cityId: Int): LiveData<List<EventsRm>> {
        return liveData {
            val data = eventsDao.readAllEvents(cityId)
            emitSource(data)
        }
    }


}