package com.example.jirataskmvvm.view.eventListPage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.model.apiClasses.City
import com.example.jirataskmvvm.model.apiClasses.Items
import com.example.jirataskmvvm.utils.SingletonCityID
import com.example.jirataskmvvm.utils.SingletonEventID
import com.example.jirataskmvvm.view.citySelectPage.citySelectionPageDirections
import com.example.jirataskmvvm.view.eventListPage.EventListPageDirections.Companion.goToEventDetailPage

class EventListPgAdapter (var events: ArrayList<Items>): RecyclerView.Adapter<EventListPgAdapter.eventListPgViewHolder>(){


    fun updateEvents(newEvents: List<Items>){
        events.clear()
        events.addAll(newEvents)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eventListPgViewHolder {
        return eventListPgViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event_list,parent,false))
    }

    override fun onBindViewHolder(holder: eventListPgViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            SingletonEventID.eventID = events[position].id
            val action = goToEventDetailPage(events[position])
            Navigation.findNavController(it).navigate(action)
        }
        holder.bind(events[position])
    }

    override fun getItemCount(): Int {
        return events.size
        Log.d("Event count :",events.size.toString())
    }



    class eventListPgViewHolder (view: View): RecyclerView.ViewHolder(view){

        private val eventName = view.findViewById<TextView>(R.id.eventName)
        private val eventFormat = view.findViewById<TextView>(R.id.eventFormat)
        private val eventCategory = view.findViewById<TextView>(R.id.eventCategory)

        fun bind(myEvent: Items){
            eventName.text = myEvent.name
            eventCategory.text = myEvent.category.name
            eventFormat.text = myEvent.format.name
        }
    }


}