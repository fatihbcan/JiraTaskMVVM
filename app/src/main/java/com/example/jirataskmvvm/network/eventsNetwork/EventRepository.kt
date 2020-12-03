package com.example.jirataskmvvm.network.eventsNetwork

import com.example.jirataskmvvm.model.Json4Kotlin_Base
import retrofit2.Response

class EventRepository {

    private val eventListClient: EventService = EventClient.eventWebService
    private val count = 300

    suspend fun getEvents(): Response<Json4Kotlin_Base> = eventListClient.getEvents(count)

}