package com.example.jirataskmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.Room.CityRm
import com.example.jirataskmvvm.Room.CityRoomRepository
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import com.example.jirataskmvvm.model.apiClasses.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityRmViewModel (application: Application):AndroidViewModel(application) {

    val allCities: LiveData<List<CityRm>>

    private val cityRoomRepository: CityRoomRepository
    private val cityRepository: CityRepository

    init {
        val cityDao = EventsDatabase.getEventsDatabase(application).cityDao()
        cityRoomRepository = CityRoomRepository(cityDao)
        allCities = cityRoomRepository.readAllData
        cityRepository = CityRepository()

    }


    private suspend fun addCity(cityRm: CityRm) {
        cityRoomRepository.addCity(cityRm)

    }

    fun load() {
        callCityApi()
    }

    private fun callCityApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val cities: List<City> = cityRepository.getCities()
            for (i in 0..cities.size) {
                val cityRm = CityRm(cities[i].id, cities[i].name)
                addCity(cityRm)
            }
        }
    }


}