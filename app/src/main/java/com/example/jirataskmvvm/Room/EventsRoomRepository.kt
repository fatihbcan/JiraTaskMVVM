package com.example.jirataskmvvm.Room

class EventsRoomRepository(private val eventsDao: EventsDao) {

    suspend fun readAllEvents(cityId: Int): List<EventsRm>
    {
        return eventsDao.readAllEvents(cityId)
    }

    suspend fun readEvent(eventId: Int): EventsRm
    {
        return eventsDao.readEvent(eventId)
    }

    suspend fun addEvent(event: EventsRm){
        eventsDao.addEvent(event)
    }


}