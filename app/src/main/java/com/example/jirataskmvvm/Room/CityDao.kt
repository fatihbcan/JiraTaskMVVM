package com.example.jirataskmvvm.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(cityRm: CityRm)

    @Query("SELECT * FROM city_table ORDER BY cId ASC")
    suspend fun readAllCities(): List<CityRm>

}