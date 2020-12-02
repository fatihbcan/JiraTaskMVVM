package com.example.jirataskmvvm.Room.repo

import androidx.lifecycle.LiveData
import com.example.jirataskmvvm.Room.dao.CityDao
import com.example.jirataskmvvm.Room.entity.CityRm

class CityRoomRepository(private val cityDao: CityDao) {

    fun readAllCities(): LiveData<List<CityRm>> {
        return cityDao.readAllCities()
    }

    suspend fun addCity(cityRm: CityRm) {
        cityDao.addCity(cityRm)
    }

}