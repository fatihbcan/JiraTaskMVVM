package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.*
import com.example.jirataskmvvm.Room.entity.EventsRm
import com.example.jirataskmvvm.Room.repo.EventsRoomRepository
import com.example.jirataskmvvm.utils.SingletonCityID
import javax.inject.Inject


class EventListViewModel @Inject constructor(eventsRoomRepository: EventsRoomRepository) :
    ViewModel() {

    val liveEvents: LiveData<List<EventsRm>> =
        eventsRoomRepository.getEvents(SingletonCityID.cityID)

}