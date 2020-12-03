package com.example.jirataskmvvm.view.eventListPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.utils.backButtonHandler
import com.example.jirataskmvvm.viewModel.EventListViewModel
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_event_list_page.view.*
import javax.inject.Inject


class EventListPage : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val eventListViewModel by viewModels<EventListViewModel> { viewModelFactory }
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


        val recyclerView = view.eventListRecycler
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

   private fun observeViewModel() {
        eventListViewModel.liveEvents.observe(viewLifecycleOwner) { events ->
            events.let {
                eventListAdapter.updateEvents(it)
            }
        }
    }


}