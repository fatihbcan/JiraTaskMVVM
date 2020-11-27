package com.example.jirataskmvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jirataskmvvm.Room.CityRm
import com.example.jirataskmvvm.Room.CityRoomRepository
import com.example.jirataskmvvm.Room.EventsDatabase
import com.example.jirataskmvvm.domain.cityPageDomain.CityRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CityRmViewModel (application: Application):AndroidViewModel(application) {

    val allCities = MutableLiveData<List<CityRm>>()
    val cityDao = EventsDatabase.getEventsDatabase(application).cityDao()
    private val cityRoomRepository: CityRoomRepository = CityRoomRepository(cityDao)
    private val cityRepository: CityRepository = CityRepository()

    init {
        viewModelScope.launch(Main) {
            val cities = cityRoomRepository.readAllCities()
            allCities.value = cities
        }
        viewModelScope.launch(IO) {
            callCityApi()
        }
    }

    private suspend fun addCity(cityRm: CityRm) {
        cityRoomRepository.addCity(cityRm)

    }


    private suspend fun callCityApi() {
        Log.d("cityRmViewModel callCityApi", "CoroutineScope is working")
        val response = cityRepository.getCities()
        try {
            if (response.isSuccessful) {
                val length = response.body()!!.size - 1
                for (i in 0..length) {
                    val cityRm = CityRm(response.body()!![i].id, response.body()!![i].name)
                    addCity(cityRm)
                }
            } else {
                Log.e("Response error !! code ", response.code().toString())
            }
        } catch (e: HttpException) {
            Log.e("Http error City Api ", e.toString())
        }
    }


}