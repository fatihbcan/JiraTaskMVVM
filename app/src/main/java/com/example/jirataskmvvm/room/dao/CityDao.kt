package com.example.jirataskmvvm.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jirataskmvvm.room.entity.CityRoom

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(cityRoom: CityRoom)

    @Query("SELECT * FROM city_table ORDER BY cId ASC")
    fun readAllCities(): LiveData<List<CityRoom>>

}