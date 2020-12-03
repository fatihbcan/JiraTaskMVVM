package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.room.entity.EventsRm
import com.example.jirataskmvvm.room.repo.EventsRoomRepository
import com.example.jirataskmvvm.utils.SingletonCityID
import javax.inject.Inject


class EventListViewModel @Inject constructor(eventsRoomRepository: EventsRoomRepository) :
    ViewModel() {

    val liveEvents: LiveData<List<EventsRm>> =
        eventsRoomRepository.getEvents(SingletonCityID.cityID)

}