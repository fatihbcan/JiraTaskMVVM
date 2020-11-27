package com.example.jirataskmvvm.model.apiClasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CityList(
    val cities: List<City>
)