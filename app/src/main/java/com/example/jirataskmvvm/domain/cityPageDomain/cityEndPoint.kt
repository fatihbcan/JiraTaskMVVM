package com.example.jirataskmvvm.domain.cityPageDomain

import com.example.jirataskmvvm.model.apiClasses.City
import com.example.jirataskmvvm.model.apiClasses.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface cityEndPoint {

    @Headers(
            "accept: application/json",
            "Content-Type: application/json",
            "X-Etkinlik-Token: d344e8fc2f852619b13d91336cc3f8d7"
    )
    @GET("cities")
    fun getCities(): Call<List<City>>
}