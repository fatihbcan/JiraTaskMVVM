package com.example.jirataskmvvm.network.citiesNetwork

import com.example.jirataskmvvm.model.City
import retrofit2.Response

class CityRepository {

    private val client: CityService = CityClient.CITY_WEBSERVICE

    suspend fun getCities(): Response<List<City>> = client.getCities()

}