package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.room.entity.EventsRoom
import com.example.jirataskmvvm.room.repo.EventsRoomRepository
import javax.inject.Inject


class EventListViewModel @Inject constructor(eventsRoomRepository: EventsRoomRepository) :
    ViewModel() {

    private val myRepo = eventsRoomRepository

    lateinit var liveEvents: LiveData<List<EventsRoom>>


    fun loadEvents(cityID: Int) {
        liveEvents = Transformations.map(myRepo.getEvents(cityID)) {
            it
        }
    }


}