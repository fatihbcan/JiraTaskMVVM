package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import kotlinx.coroutines.Dispatchers

class EventListViewModel : ViewModel() {

    //val liveEvents = MutableLiveData<List<Items>>()
    private val eventListRepo = EventListRepository()

    val liveEvents = liveData(Dispatchers.IO) {
        val retrieved = eventListRepo.getEvents().items

        emit(retrieved)
    }

    /*fun loadData(){
        callEventListApi()
    }
*/


}