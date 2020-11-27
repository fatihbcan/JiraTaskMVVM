package com.example.jirataskmvvm.domain.cityPageDomain

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CityService {

    val webservice: CityEndPoint by lazy {
        Retrofit.Builder()
            .baseUrl("https://backend.etkinlik.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(CityEndPoint::class.java)


    }
}