package com.example.jirataskmvvm.domain.eventListDomain

import com.example.jirataskmvvm.model.apiClasses.Json4Kotlin_Base
import com.example.jirataskmvvm.utils.SingletonCityID

class EventListRepository {

    val eventListClient: EventListEndPoint = EventListApiService.eventWebService
    val cityID = SingletonCityID.cityID

    suspend fun getEvents(): Json4Kotlin_Base = eventListClient.getEvents(cityID)

}