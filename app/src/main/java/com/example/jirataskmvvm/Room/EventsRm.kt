package com.example.jirataskmvvm.Room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "events_table")
data class EventsRm(

    @PrimaryKey(autoGenerate = true)
    val eId: Int,
    val name: String,
    val start: String,
    val end: String,
    val is_free: Boolean,
    val poster_url: String,
    val ticket_url: String,
    val format: String,
    val category: String,
    val cityId: Int,
    val cityName: String

)