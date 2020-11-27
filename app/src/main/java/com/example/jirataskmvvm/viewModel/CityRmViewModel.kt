package com.example.jirataskmvvm.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class CityRmViewModel (application: Application):AndroidViewModel(application){

    //val readAllCities: MutableLiveData<List<CityRm>>
    private val cityRoomRepository: CityRoomRepository

    init {
        val cityDao = EventsDatabase.getEventsDatabase(application).cityDao()
        cityRoomRepository = CityRoomRepository(cityDao)
        //readAllCities = cityRoomRepository.readAllData
    }


    fun loadCityTable(){
        loadDB()
    }

    private fun loadDB(){
        cityRoomRepository.callCityApiRoom()
    }
}