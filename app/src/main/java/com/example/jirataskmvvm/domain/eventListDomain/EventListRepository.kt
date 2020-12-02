package com.example.jirataskmvvm.domain.eventListDomain

import com.example.jirataskmvvm.model.apiClasses.Json4Kotlin_Base
import retrofit2.Response

class EventListRepository {

    private val eventListClient: EventListEndPoint = EventListApiService.eventWebService
    private val count = 300

    suspend fun getEvents(): Response<Json4Kotlin_Base> = eventListClient.getEvents(count)

}