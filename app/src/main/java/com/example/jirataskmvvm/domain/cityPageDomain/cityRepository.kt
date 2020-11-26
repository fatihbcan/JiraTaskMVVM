package com.example.jirataskmvvm.domain.cityPageDomain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jirataskmvvm.model.apiClasses.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class cityRepository{


    fun callCityApi(liveData: MutableLiveData<List<City>>){
        val request = cityService.buildService(cityEndPoint::class.java)
        val call = request.getCities()

        call.enqueue(object : Callback<List<City>> {
            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                if (response.isSuccessful) {
                    //liveData.value = eventsList.eventsList
                    liveData.value = response.body()!!
                    Log.d("api response:", " success")
                }
            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {
                liveData.value = null
                Log.d("api response:", t.message.toString())
            }

        })

    }

}