package com.example.jirataskmvvm.domain.eventListDomain

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EventListApiService {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://backend.etkinlik.io/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

}