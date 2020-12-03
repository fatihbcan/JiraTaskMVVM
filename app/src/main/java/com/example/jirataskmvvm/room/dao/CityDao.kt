package com.example.jirataskmvvm.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jirataskmvvm.room.entity.CityRm

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(cityRm: CityRm)

    @Query("SELECT * FROM city_table ORDER BY cId ASC")
    fun readAllCities(): LiveData<List<CityRm>>

}