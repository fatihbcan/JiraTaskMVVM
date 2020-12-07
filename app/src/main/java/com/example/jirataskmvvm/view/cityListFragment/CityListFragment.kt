package com.example.jirataskmvvm.view.cityListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.utils.CityRecyclerViewClickListener
import com.example.jirataskmvvm.viewModel.CityListViewModel
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_city_selection_page.*
import javax.inject.Inject


class CityListFragment : DaggerFragment(), CityRecyclerViewClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val cityViewModel by viewModels<CityListViewModel> { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_selection_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loads room database on IO thread
        cityViewModel.loadData()

        cityViewModel.allCities.observe(viewLifecycleOwner, { cities ->
            cityFragmentRecycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = CityListAdapter(cities, this)
            }
        })
    }


    // navigates to event list fragment for clicked city
    override fun onRecyclerViewItemClick(cityRoom: CityRoom) {
        val action = CityListFragmentDirections.goToEventListFragment(cityRoom.cId)
        findNavController().navigate(action)

    }
}