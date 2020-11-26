package com.example.jirataskmvvm.model.apiClasses

import com.google.gson.annotations.SerializedName


data class Json4Kotlin_Base (

	@SerializedName("meta") val meta : Meta,
	@SerializedName("items") val items : List<Items>
)