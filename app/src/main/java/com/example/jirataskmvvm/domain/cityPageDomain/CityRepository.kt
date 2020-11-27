package com.example.jirataskmvvm.domain.cityPageDomain

import com.example.jirataskmvvm.model.apiClasses.City
import retrofit2.Response

class CityRepository {

    val client: CityEndPoint = CityService.webservice

    suspend fun getCities(): Response<List<City>> = client.getCities()

}