package com.example.jirataskmvvm.Room

class CityRoomRepository(private val cityDao: CityDao) {

    suspend fun readAllCities(): List<CityRm> {
        return cityDao.readAllCities()
    }

    suspend fun addCity(cityRm: CityRm) {
        cityDao.addCity(cityRm)
    }

}