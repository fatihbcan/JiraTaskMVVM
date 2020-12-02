package com.example.jirataskmvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.Room.entity.CityRm
import com.example.jirataskmvvm.Room.repo.CityRoomRepository
import com.example.jirataskmvvm.Room.repo.EventsRoomRepository
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import com.example.jirataskmvvm.utils.InternetConnectionCheck
import com.example.jirataskmvvm.utils.callCityApi
import com.example.jirataskmvvm.utils.callEventApi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class   CityRmViewModel (application: Application):AndroidViewModel(application) {

    val allCities: LiveData<List<CityRm>> = liveData {
        val data = cityRoomRepository.readAllCities()
        emitSource(data)

    }


    private val cityDao = EventsDatabase.getEventsDatabase(application).cityDao()
    private val eventDao = EventsDatabase.getEventsDatabase(application).eventDao()
    private val cityRoomRepository: CityRoomRepository = CityRoomRepository(cityDao)
    private val cityRepository: CityRepository = CityRepository()
    private val eventRepository: EventListRepository = EventListRepository()
    private val eventRoomRepository: EventsRoomRepository = EventsRoomRepository(eventDao)

    init {
        viewModelScope.launch(IO) {
            try {
                if (InternetConnectionCheck(application)) {
                    callCityApi(cityRepository, cityRoomRepository)
                }
            } catch (e: Exception) {
                Log.e("internet connection check error ", e.toString())
            }
        }
        viewModelScope.launch(IO) {
            try {
                if (InternetConnectionCheck(application)) {
                    callEventApi(eventRepository, eventRoomRepository)
                }
            } catch (e: Exception) {
                Log.e("internet connection check error ", e.toString())
            }
        }
    }

    /*suspend fun loadData() {
        allCities.value = cityRoomRepository.readAllCities()
    }*/

}



