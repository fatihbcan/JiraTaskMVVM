package com.example.jirataskmvvm.utils

import android.view.View
import com.example.jirataskmvvm.room.entity.EventsRoom


// Click listener for event list fragments' recycler view

interface EventsRecyclerClickListener {
    fun onRecyclerViewItemClick(view: View, eventsRoom: EventsRoom)
}