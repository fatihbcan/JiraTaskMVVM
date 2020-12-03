package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.room.entity.CityRm
import com.example.jirataskmvvm.room.repo.CityRoomRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class   CityRmViewModel @Inject constructor(
    private val citiesRoomRepository: CityRoomRepository
):ViewModel() {

    val allCities: LiveData<List<CityRm>> = citiesRoomRepository.getCities()

    fun loadData(){
        viewModelScope.launch(IO){
            citiesRoomRepository.loadCitiesToDb()
            citiesRoomRepository.loadEventsToDb()
        }
    }

}


