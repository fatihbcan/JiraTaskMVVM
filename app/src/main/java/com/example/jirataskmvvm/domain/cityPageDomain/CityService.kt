package com.example.jirataskmvvm.domain.cityPageDomain

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object cityService {

    private val client = OkHttpClient.Builder().build()

    val retrofit by lazy { Retrofit.Builder()
        .baseUrl("https://backend.etkinlik.io/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(client)
        .build() }

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

}