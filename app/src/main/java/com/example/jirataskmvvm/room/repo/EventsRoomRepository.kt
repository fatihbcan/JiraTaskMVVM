package com.example.jirataskmvvm.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.EventsRm
import javax.inject.Inject

class EventsRoomRepository @Inject constructor(private val eventsDao: EventsDao) {

    fun getEvents(cityId: Int): LiveData<List<EventsRm>> {
        return liveData {
            val data = eventsDao.readAllEvents(cityId)
            emitSource(data)
        }
    }


}