package com.example.jirataskmvvm.view.eventListPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.viewModel.EventListViewModel


class EventListPage : Fragment() {

    lateinit var eventListViewModel: EventListViewModel
    private val eventListAdapter = EventListPgAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_list_page, container, false)


        eventListViewModel = ViewModelProviders.of(this).get(EventListViewModel::class.java)
        eventListViewModel.loadData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.eventListRecycler)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }



        observeViewModel()

        return view
    }

    fun observeViewModel(){
        eventListViewModel.liveEvents.observe(viewLifecycleOwner, { events -> events?.let {
            eventListAdapter.updateEvents(it)
        }
        })
    }

}