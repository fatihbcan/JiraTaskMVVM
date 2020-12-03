package com.example.jirataskmvvm.network.eventsNetwork

import com.example.jirataskmvvm.model.Json4Kotlin_Base
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EventService {

    @Headers(
        "accept: application/json",
        "Content-Type: application/json",
        "X-Etkinlik-Token: d344e8fc2f852619b13d91336cc3f8d7"
    )
    @GET("events")
    suspend fun getEvents(
        @Query("take") count: Int
    ): Response<Json4Kotlin_Base>
}