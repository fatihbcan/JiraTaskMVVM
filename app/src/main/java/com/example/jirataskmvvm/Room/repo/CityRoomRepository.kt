package com.example.jirataskmvvm.Room.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.Room.dao.CityDao
import com.example.jirataskmvvm.Room.dao.EventsDao
import com.example.jirataskmvvm.Room.entity.CityRm
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import com.example.jirataskmvvm.utils.InternetConnectionCheck
import com.example.jirataskmvvm.utils.callCityApi
import com.example.jirataskmvvm.utils.callEventApi
import javax.inject.Inject

class CityRoomRepository @Inject constructor(
    private val cityDao: CityDao,
    private val eventsDao: EventsDao,
    private val cityRepository: CityRepository,
    private val eventsListRepository: EventListRepository,
    private val application: Application
) {

    fun getCities(): LiveData<List<CityRm>> {
        return liveData {
            val data = cityDao.readAllCities()
            emitSource(data)
        }
    }

    suspend fun loadCitiesToDb() {
        try {
            if (InternetConnectionCheck(application)) {
                callCityApi(cityRepository, cityDao)
            }
        } catch (e: Exception) {
            Log.e("internet connection check error ", e.toString())
        }
    }

    suspend fun loadEventsToDb() {
        try {
            if (InternetConnectionCheck(application)) {
                callEventApi(eventsListRepository, eventsDao)
            }
        } catch (e: Exception) {
            Log.e("internet connection check error ", e.toString())
        }
    }

}