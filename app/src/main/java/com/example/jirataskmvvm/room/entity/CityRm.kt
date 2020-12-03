package com.example.jirataskmvvm.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "city_table")
data class CityRm(

    @PrimaryKey(autoGenerate = true)
    val cId: Int,
    val name: String

)