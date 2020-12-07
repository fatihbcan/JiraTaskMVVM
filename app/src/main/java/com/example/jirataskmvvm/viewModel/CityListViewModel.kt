package com.example.jirataskmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.room.repo.CityRoomRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class CityListViewModel @Inject constructor(
    private val citiesRoomRepository: CityRoomRepository
) : ViewModel() {

    val allCities: LiveData<List<CityRoom>> = citiesRoomRepository.getCities()

    fun loadData() {
        viewModelScope.launch(IO) {
            citiesRoomRepository.loadCitiesToDb()
            citiesRoomRepository.loadEventsToDb()
        }
    }

}


