package com.example.jirataskmvvm.view.citySelectPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.viewModel.CityRmViewModel
import kotlinx.android.synthetic.main.fragment_city_selection_page.view.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch


class citySelectionPage : Fragment() {

    lateinit var cityViewModel: CityRmViewModel
    private val cityAdapter = cityScPageAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_city_selection_page, container, false)

        cityViewModel = ViewModelProvider(this).get(CityRmViewModel::class.java)
        lifecycleScope.launch(Main) {
            cityViewModel.loadData()
        }

        val recyclerView = view.cityPageRecycler
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = cityAdapter
        }

        observeViewModel()
        return view
    }

    fun observeViewModel(){
        cityViewModel.allCities.observe(viewLifecycleOwner, { cities ->
            cities?.let {
                cityAdapter.updateCities(it)
            }
        })
    }

}