package com.example.jirataskmvvm.utils

import android.util.Log
import com.example.jirataskmvvm.network.citiesNetwork.CityRepository
import com.example.jirataskmvvm.network.eventsNetwork.EventRepository
import com.example.jirataskmvvm.room.dao.CityDao
import com.example.jirataskmvvm.room.dao.EventsDao
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.room.entity.EventsRoom
import retrofit2.HttpException


//calls city list from api

suspend fun callCityApi(cityRepository: CityRepository, cityDao: CityDao) {
    val response = cityRepository.getCities()
    try {
        if (response.isSuccessful) {
            val length = response.body()!!.size - 1
            for (i in 0..length) {
                val cityRm = CityRoom(response.body()!![i].id, response.body()!![i].name)
                cityDao.addCity(cityRm)
            }
        } else {
            Log.e("Response error !! code ", response.code().toString())
        }
    } catch (e: HttpException) {
        Log.e("Http error City Api ", e.toString())
        e.stackTrace
    }
}


//calls event list and details from api

suspend fun callEventApi(
    eventsRepository: EventRepository,
    eventsDao: EventsDao
) {
    val response = eventsRepository.getEvents()
    try {
        if (response.isSuccessful) {
            val length = response.body()!!.items.size
            for (j in 0..length) {
                val cityId: Int = if (response.body()!!.items[j].venue == null) {
                    99
                } else {
                    response.body()!!.items[j].venue.city.id
                }
                val address: String = if (response.body()!!.items[j].venue == null) {
                    "Online Etkinlik"
                } else {
                    response.body()!!.items[j].venue.address
                }

                val event = EventsRoom(
                    response.body()!!.items[j].id,
                    response.body()!!.items[j].name,
                    getDate(response.body()!!.items[j].start),
                    getDate(response.body()!!.items[j].end),
                    response.body()!!.items[j].is_free,
                    response.body()!!.items[j].poster_url,
                    response.body()!!.items[j].ticket_url,
                    response.body()!!.items[j].format.name,
                    response.body()!!.items[j].category.name,
                    cityId,
                    address
                )
                eventsDao.addEvent(event)
            }
        } else {
            Log.e("Response error !! code ", response.code().toString())
        }
    } catch (e: HttpException) {
        Log.e("Http error City Api ", e.toString())
        e.stackTrace
    }
}