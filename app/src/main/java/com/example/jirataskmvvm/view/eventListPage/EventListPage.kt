package com.example.jirataskmvvm.view.eventListPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.utils.backButtonHandler
import com.example.jirataskmvvm.viewModel.EventListViewModel


class EventListPage : Fragment() {

    lateinit var eventListViewModel: EventListViewModel
    private val eventListAdapter = EventListPgAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val action = EventListPageDirections.goToCitySelectionPage()
        backButtonHandler(this, requireActivity(), action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_list_page, container, false)


        eventListViewModel = ViewModelProvider(this).get(EventListViewModel::class.java)


        val recyclerView = view.findViewById<RecyclerView>(R.id.eventListRecycler)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }


        observeViewModel()

        return view
    }

    fun observeViewModel() {
        eventListViewModel.liveEvents.observe(viewLifecycleOwner, { events ->
            events?.let {
                eventListAdapter.updateEvents(it)
            }
        })
    }


}