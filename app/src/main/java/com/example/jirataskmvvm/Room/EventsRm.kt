package com.example.jirataskmvvm.Room




data class EventsRm(

    val id: Int,
    val name: String,
    val start: String,
    val end: String,
    val is_free: Boolean,
    val poster_url: String,
    val ticket_url: String,
    val format: FormatRm,
    val category: CategoryRm,
    val venue: VenueRm,

)