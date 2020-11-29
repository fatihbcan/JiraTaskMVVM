package com.example.jirataskmvvm.domain.eventListDomain

import com.example.jirataskmvvm.model.apiClasses.Json4Kotlin_Base
import com.example.jirataskmvvm.utils.SingletonCityID
import com.example.jirataskmvvm.utils.SingletonCityIDRoom
import retrofit2.Response

class EventListRepository {

    val eventListClient: EventListEndPoint = EventListApiService.eventWebService
    val cityID = SingletonCityIDRoom.cityID

    suspend fun getEvents(): Response<Json4Kotlin_Base> = eventListClient.getEvents(cityID)

}