package com.example.jirataskmvvm.network.citiesNetwork

import com.example.jirataskmvvm.model.City
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CityService {

    @Headers(
        "accept: application/json",
        "Content-Type: application/json",
        "X-Etkinlik-Token: d344e8fc2f852619b13d91336cc3f8d7"
    )
    @GET("cities")
    suspend fun getCities(): Response<List<City>>
}