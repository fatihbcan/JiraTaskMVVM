package com.example.jirataskmvvm.view.eventListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.room.entity.EventsRm
import com.example.jirataskmvvm.utils.SingletonEventID
import kotlinx.android.synthetic.main.item_event_list.view.*


class EventListAdapter(private var events: ArrayList<EventsRm>) :
    RecyclerView.Adapter<EventListAdapter.EventListViewHolder>() {


    fun updateEvents(newEvents: List<EventsRm>) {
        events.clear()
        events.addAll(newEvents)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        return EventListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_event_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            SingletonEventID.eventID = events[position].cityId
            val action = EventListFragmentDirections.goToEventDetailFragment(events[position])
            Navigation.findNavController(it).navigate(action)
        }
        holder.bind(events[position])
    }

    override fun getItemCount(): Int {
        return events.size
    }


    class EventListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val eventName = view.eventFragEventName
        private val eventFormat = view.eventFragEventFormat
        private val eventCategory = view.eventFragEventCategory

        fun bind(myEvent: EventsRm) {
            eventName.text = myEvent.name
            eventCategory.text = myEvent.category
            eventFormat.text = myEvent.format
        }
    }


}