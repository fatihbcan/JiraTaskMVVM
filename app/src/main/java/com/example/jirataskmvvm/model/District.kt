package com.example.jirataskmvvm.model

import com.google.gson.annotations.SerializedName

data class District(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String
)