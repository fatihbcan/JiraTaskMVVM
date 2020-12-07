package com.example.jirataskmvvm.view.eventListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.room.entity.EventsRoom
import com.example.jirataskmvvm.utils.EventsRecyclerClickListener
import com.example.jirataskmvvm.viewModel.EventListViewModel
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_event_list_page.*
import javax.inject.Inject


class EventListFragment : DaggerFragment(), EventsRecyclerClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val args: EventListFragmentArgs by navArgs()

    private val eventListViewModel by viewModels<EventListViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_list_page, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loads events for desired city
        eventListViewModel.loadEvents(args.cityID)

        eventListViewModel.liveEvents.observe(viewLifecycleOwner, { events ->
            eventListRecycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = EventListAdapter(events, this)
            }
        })
    }

    // navigates to clicked events' detail fragment
    override fun onRecyclerViewItemClick(view: View, eventsRoom: EventsRoom) {
        val action = EventListFragmentDirections.goToEventDetailFragment(eventsRoom)
        Navigation.findNavController(view).navigate(action)
    }


}