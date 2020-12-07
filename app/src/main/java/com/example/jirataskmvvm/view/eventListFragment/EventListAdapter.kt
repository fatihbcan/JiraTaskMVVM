package com.example.jirataskmvvm.view.eventListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.databinding.ItemEventListBinding
import com.example.jirataskmvvm.room.entity.EventsRoom
import com.example.jirataskmvvm.utils.EventsRecyclerClickListener


class EventListAdapter(
    private var events: List<EventsRoom>,
    private val listenerEvent: EventsRecyclerClickListener
) :
    RecyclerView.Adapter<EventListAdapter.EventListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventListViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_event_list,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.itemEventListBinding.event = events[position]
        holder.itemEventListBinding.root.setOnClickListener {
            listenerEvent.onRecyclerViewItemClick(
                holder.itemEventListBinding.root,
                events[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }


    class EventListViewHolder(val itemEventListBinding: ItemEventListBinding) :
        RecyclerView.ViewHolder(itemEventListBinding.root)


}