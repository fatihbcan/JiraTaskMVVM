package com.example.jirataskmvvm.room.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.network.citiesNetwork.CityRepository
import com.example.jirataskmvvm.network.eventsNetwork.EventRepository
import com.example.jirataskmvvm.room.dao.CityDao
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.utils.callCityApi
import com.example.jirataskmvvm.utils.callEventApi
import com.example.jirataskmvvm.utils.internetConnectionCheck
import javax.inject.Inject

class CityRoomRepository @Inject constructor(
    private val cityDao: CityDao,
    private val eventsDao: EventsDao,
    private val cityRepository: CityRepository,
    private val eventsRepository: EventRepository,
    private val application: Application
) {

    // gets all cities from room
    fun getCities(): LiveData<List<CityRoom>> {
        return liveData {
            val data = cityDao.readAllCities()
            emitSource(data)
        }
    }

    // adds cities to DB from api call
    suspend fun loadCitiesToDb() {
        try {
            if (internetConnectionCheck(application)) {
                callCityApi(cityRepository, cityDao)
            }
        } catch (e: Exception) {
            Log.e("internet connection check error ", e.toString())
            e.stackTrace
        }
    }

    // adds events to DB from api call
    suspend fun loadEventsToDb() {
        try {
            if (internetConnectionCheck(application)) {
                callEventApi(eventsRepository, eventsDao)
            }
        } catch (e: Exception) {
            Log.e("internet connection check error ", e.toString())
            e.stackTrace
        }
    }

}