package com.example.jirataskmvvm.view.cityListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.databinding.ItemCitiesBinding
import com.example.jirataskmvvm.room.entity.CityRoom
import com.example.jirataskmvvm.utils.CityRecyclerViewClickListener

class CityListAdapter(
    private val cities: List<CityRoom>,
    private val listenerCity: CityRecyclerViewClickListener
) :
    RecyclerView.Adapter<CityListAdapter.CityViewHolder>() {


    class CityViewHolder(
        private val itemCitiesBinding: ItemCitiesBinding,
        private val listenerCity: CityRecyclerViewClickListener
    ) :
        RecyclerView.ViewHolder(itemCitiesBinding.root) {

        fun bind(item: CityRoom) {
            itemCitiesBinding.cityRoom = item
            itemCitiesBinding.clickListener = listenerCity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CityViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_cities,
            parent,
            false
        ), listenerCity
    )


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount(): Int = cities.size
}

