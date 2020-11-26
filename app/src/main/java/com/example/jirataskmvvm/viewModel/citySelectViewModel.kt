package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jirataskmvvm.domain.cityPageDomain.cityRepository
import com.example.jirataskmvvm.model.apiClasses.City


class citySelectViewModel : ViewModel(){

    val liveCities = MutableLiveData<List<City>>()
    private val myCityRepository = cityRepository()

    private fun callCityApi(){
        myCityRepository.callCityApi(liveCities)

    }

    fun loadData() {
        callCityApi()
    }

}