package com.example.jirataskmvvm.Room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "city_table")
data class CityRm(


    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)