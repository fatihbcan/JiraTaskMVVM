package com.example.jirataskmvvm.network.citiesNetwork

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CityClient {

    val CITY_WEBSERVICE: CityService by lazy {
        Retrofit.Builder()
            .baseUrl("https://backend.etkinlik.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(CityService::class.java)


    }
}