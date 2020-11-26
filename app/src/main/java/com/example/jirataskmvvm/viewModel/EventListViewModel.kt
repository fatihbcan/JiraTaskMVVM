package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.domain.eventListDomain.EventListRepository
import com.example.jirataskmvvm.model.apiClasses.Items
import com.example.jirataskmvvm.utils.SingletonCityID

class EventListViewModel : ViewModel(){

    var defaultCityID = SingletonCityID.myCityID()
    val liveEvents = MutableLiveData<List<Items>>()
    private val eventListRepo = EventListRepository()

    private fun callEventListApi(){
        eventListRepo.callEventListApi(liveEvents,defaultCityID)

    }

    fun loadData() {
        callEventListApi()
    }

}