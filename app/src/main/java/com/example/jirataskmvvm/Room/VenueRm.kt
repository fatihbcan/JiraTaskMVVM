package com.example.jirataskmvvm.Room


data class VenueRm(
    val id: Int,
    val name: String,
    val slug: String,
    val about: String,
    val lat: Double,
    val lng: Double,
    val phone: String,
    val address: String
)