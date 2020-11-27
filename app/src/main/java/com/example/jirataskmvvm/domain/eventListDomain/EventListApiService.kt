package com.example.jirataskmvvm.domain.eventListDomain

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EventListApiService {

    val eventWebService by lazy {
        Retrofit.Builder()
            .baseUrl("https://backend.etkinlik.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(EventListEndPoint::class.java)


    }

}