package com.example.jirataskmvvm.view.citySelectPage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.Room.CityRm
import com.example.jirataskmvvm.utils.SingletonCityID

class cityScPageAdapter(var myCities: ArrayList<CityRm>) :
    RecyclerView.Adapter<cityScPageAdapter.cityScPageViewHolder>() {


    fun updateCities(newCities: List<CityRm>) {
        myCities.clear()
        myCities.addAll(newCities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cityScPageViewHolder {
        return cityScPageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cities, parent, false)
        )
    }

    override fun onBindViewHolder(holder: cityScPageViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            SingletonCityID.cityID = myCities[position].cId
            val action = citySelectionPageDirections.goToEventListPage()
            Navigation.findNavController(it).navigate(action)
        }
        holder.bind(myCities[position])
    }

    override fun getItemCount(): Int {
        Log.d("live data size",myCities.size.toString())
        return myCities.size
    }

    class cityScPageViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val cityName = view.findViewById<TextView>(R.id.cityName)

        fun bind(myCity: CityRm) {
            cityName.text = myCity.name
        }
    }

}