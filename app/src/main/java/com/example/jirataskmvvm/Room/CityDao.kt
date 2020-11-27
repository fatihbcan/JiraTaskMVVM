package com.example.jirataskmvvm.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(cityRm: CityRm)

    @Query("SELECT * FROM city_table ORDER BY id ASC")
    fun readAllCities(): LiveData<List<CityRm>>

}