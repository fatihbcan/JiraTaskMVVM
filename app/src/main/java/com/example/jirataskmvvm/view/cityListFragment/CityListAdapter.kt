package com.example.jirataskmvvm.view.cityListFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.room.entity.CityRm
import com.example.jirataskmvvm.utils.SingletonCityID
import kotlinx.android.synthetic.main.item_cities.view.*

class CityListAdapter(private var myCities: ArrayList<CityRm>) :
    RecyclerView.Adapter<CityListAdapter.CityListViewHolder>() {


    fun updateCities(newCities: List<CityRm>) {
        myCities.clear()
        myCities.addAll(newCities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListViewHolder {
        return CityListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cities, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            SingletonCityID.cityID = myCities[position].cId
            val action = CityListFragmentDirections.goToEventListFragment()
            Navigation.findNavController(it).navigate(action)
        }
        holder.bind(myCities[position])
    }

    override fun getItemCount(): Int {
        Log.d("live data size", myCities.size.toString())
        return myCities.size
    }

    class CityListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val cityName = view.cityFragmentcityName

        fun bind(myCity: CityRm) {
            cityName.text = myCity.name
        }
    }

}