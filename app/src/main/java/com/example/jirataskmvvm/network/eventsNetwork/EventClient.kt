package com.example.jirataskmvvm.network.eventsNetwork

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EventClient {

    val eventWebService by lazy {
        Retrofit.Builder()
            .baseUrl("https://backend.etkinlik.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(EventService::class.java)


    }

}