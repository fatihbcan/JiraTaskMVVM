package com.example.jirataskmvvm.Room

import androidx.lifecycle.LiveData

class CityRoomRepository(private val cityDao: CityDao) {

    val readAllData: LiveData<List<CityRm>> = cityDao.readAllCities()

    suspend fun addCity(cityRm: CityRm) {
        cityDao.addCity(cityRm)
    }

}