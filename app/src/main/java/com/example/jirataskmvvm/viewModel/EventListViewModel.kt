package com.example.jirataskmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.Room.EventsRm
import com.example.jirataskmvvm.Room.EventsRoomRepository
import com.example.jirataskmvvm.utils.SingletonCityID
import com.example.jirataskmvvm.utils.SingletonCityIDRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EventListViewModel(application: Application): AndroidViewModel(application) {

    val liveEvents = MutableLiveData<List<EventsRm>>()
    private val eventDao = EventsDatabase.getEventsDatabase(application).eventDao()
    private val eventRoomRepository: EventsRoomRepository = EventsRoomRepository(eventDao)


    init {
        viewModelScope.launch(Dispatchers.Main){
            val events = eventRoomRepository.readAllEvents(SingletonCityID.cityID)
            liveEvents.value = events
        }
    }

}