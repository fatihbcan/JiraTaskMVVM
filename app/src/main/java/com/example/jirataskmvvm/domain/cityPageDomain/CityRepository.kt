package com.example.jirataskmvvm.domain.cityPageDomain

import com.example.jirataskmvvm.model.apiClasses.City

class CityRepository {

    val client: CityEndPoint = CityService.webservice

    suspend fun getCities(): List<City> = client.getCities()

}