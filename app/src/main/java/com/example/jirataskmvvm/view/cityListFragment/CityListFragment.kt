package com.example.jirataskmvvm.view.cityListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.viewModel.CityRmViewModel
import com.example.jirataskmvvm.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_city_selection_page.view.*
import javax.inject.Inject


class CityListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val cityViewModel by viewModels<CityRmViewModel> { viewModelFactory }
    private val cityAdapter = CityListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_city_selection_page, container, false)
        cityViewModel.loadData()

        val recyclerView = view.cityFragmentRecycler
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = cityAdapter
        }



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }


     private fun observeViewModel() {
        if (cityViewModel.allCities.value.isNullOrEmpty()) {
            cityViewModel.allCities.observe(viewLifecycleOwner) { cities ->
                cities.let {
                    cityAdapter.updateCities(it)
                }
            }
        } else {
            cityViewModel.allCities.observe(viewLifecycleOwner) { cities ->
                cities.let {
                    cityAdapter.updateCities(it)
                }
            }
        }

    }
}