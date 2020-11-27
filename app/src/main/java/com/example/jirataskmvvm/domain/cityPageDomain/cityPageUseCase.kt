package com.example.jirataskmvvm.domain.cityPageDomain

import com.example.jirataskmvvm.Room.CityRm
import com.example.jirataskmvvm.Room.CityRoomRepository

class GetCityPageUseCase(
    private val cityRoomRepository: CityRoomRepository
) {


    sealed class Result {
        data class Success(val data: List<CityRm>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    /* suspend fun execute(): Result{
         return try {
             Result.Success(cityRoomRepository.())
         }catch (e: IOException){
             Result.Error(e)
         }
     }*/


}
