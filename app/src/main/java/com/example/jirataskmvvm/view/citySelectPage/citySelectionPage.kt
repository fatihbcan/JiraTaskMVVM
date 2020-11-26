package com.example.jirataskmvvm.view.citySelectPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.viewModel.citySelectViewModel


class citySelectionPage : Fragment() {

    lateinit var cityViewModel: citySelectViewModel
    private val cityAdapter = cityScPageAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_city_selection_page, container, false)

        cityViewModel = ViewModelProvider(this).get(citySelectViewModel::class.java)
        cityViewModel.loadData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.cityPageRecycler)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = cityAdapter
        }

        observeViewModel()
        return view
    }

    fun observeViewModel(){
        cityViewModel.liveCities.observe(viewLifecycleOwner, { cities -> cities?.let {
                cityAdapter.updateCities(it)
        }
        })
    }

}