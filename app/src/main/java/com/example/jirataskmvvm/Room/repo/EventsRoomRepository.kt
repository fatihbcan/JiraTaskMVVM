package com.example.jirataskmvvm.Room.repo

import com.example.jirataskmvvm.Room.dao.EventsDao
import com.example.jirataskmvvm.Room.entity.EventsRm

class EventsRoomRepository(private val eventsDao: EventsDao) {

    suspend fun readAllEvents(cityId: Int): List<EventsRm> {
        return eventsDao.readAllEvents(cityId)
    }

    suspend fun addEvent(event: EventsRm) {
        eventsDao.addEvent(event)
    }


}