package com.example.jirataskmvvm.utils

import android.util.Log
import com.example.jirataskmvvm.Room.CityRm
import com.example.jirataskmvvm.Room.CityRoomRepository
import com.example.jirataskmvvm.Room.EventsRm
import com.example.jirataskmvvm.Room.EventsRoomRepository
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import retrofit2.HttpException

suspend fun callCityApi(cityRepository: CityRepository, cityRoomRepository: CityRoomRepository) {
    Log.d("cityRmViewModel callCityApi", "CoroutineScope is working")
    val response = cityRepository.getCities()
    try {
        if (response.isSuccessful) {
            val length = response.body()!!.size - 1
            SingletonCityLength.cityLength = length
            for (i in 0..length) {
                val cityRm = CityRm(response.body()!![i].id, response.body()!![i].name)
                cityRoomRepository.addCity(cityRm)
            }
        } else {
            Log.e("Response error !! code ", response.code().toString())
        }
    } catch (e: HttpException) {
        Log.e("Http error City Api ", e.toString())
    }
}

suspend fun callEventApi(
    eventsRepository: EventListRepository,
    eventsRoomRepository: EventsRoomRepository
) {
    Log.d("cityRmViewModel callCityApi", "CoroutineScope is working")
    val response = eventsRepository.getEvents()
    try {
        if (response.isSuccessful) {
            val length = response.body()!!.items.size
            for (j in 0..length) {
                val cityId : Int = if (response.body()!!.items[j].venue==null){
                    99
                }else{
                    response.body()!!.items[j].venue.city.id
                }
                val cityName : String = if(response.body()!!.items[j].venue==null){
                    ""
                }else{
                    response.body()!!.items[j].venue.city.name
                }

                val event = EventsRm(
                    response.body()!!.items[j].id,
                    response.body()!!.items[j].name,
                    response.body()!!.items[j].start,
                    response.body()!!.items[j].end,
                    response.body()!!.items[j].is_free,
                    response.body()!!.items[j].poster_url,
                    response.body()!!.items[j].ticket_url,
                    response.body()!!.items[j].format.name,
                    response.body()!!.items[j].category.name,
                    cityId,
                    cityName
                )
                eventsRoomRepository.addEvent(event)
            }
        } else {
            Log.e("Response error !! code ", response.code().toString())
        }
    } catch (e: HttpException) {
        Log.e("Http error City Api ", e.toString())
    }
}