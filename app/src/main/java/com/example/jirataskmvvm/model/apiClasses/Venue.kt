package com.example.jirataskmvvm.model.apiClasses

import com.google.gson.annotations.SerializedName


data class Venue (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("about") val about : String,
	@SerializedName("lat") val lat : Double,
	@SerializedName("lng") val lng : Double,
	@SerializedName("phone") val phone : String,
	@SerializedName("web_url") val web_url : String,
	@SerializedName("facebook_url") val facebook_url : String,
	@SerializedName("twitter_url") val twitter_url : String,
	@SerializedName("city") val city : City,
	@SerializedName("district") val district : District,
	@SerializedName("neighborhood") val neighborhood : Neighborhood,
	@SerializedName("address") val address : String
)