package com.example.jirataskmvvm.utils

import com.example.jirataskmvvm.room.entity.CityRoom


// Click listener for city list fragments' recycler view

interface CityRecyclerViewClickListener {
    fun onRecyclerViewItemClick(cityRoom: CityRoom)
}