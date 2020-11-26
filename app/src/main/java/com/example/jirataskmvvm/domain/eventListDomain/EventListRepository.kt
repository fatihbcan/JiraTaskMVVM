package com.example.jirataskmvvm.domain.eventListDomain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jirataskmvvm.model.apiClasses.Items
import com.example.jirataskmvvm.model.apiClasses.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventListRepository{


    fun callEventListApi(liveData: MutableLiveData<List<Items>>,cityID: Int){
        val request = EventListApiService.buildService(EventListEndPoint::class.java)
        val call = request.getEvents(cityID)
        Log.d("incoming City ID :",cityID.toString())
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(call: Call<Json4Kotlin_Base>, response: Response<Json4Kotlin_Base>) {
                if (response.isSuccessful) {
                    //liveData.value = eventsList.eventsList
                    liveData.value = response.body()!!.items
                    Log.d("api response:", " success")
                }
            }

            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                liveData.value = null
                Log.d("api response:", " failure")
            }

        })

    }

}