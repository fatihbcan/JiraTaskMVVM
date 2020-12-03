package com.example.jirataskmvvm.model

import com.google.gson.annotations.SerializedName


data class Items (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("url") val url : String,
	@SerializedName("content") val content : String,
	@SerializedName("start") val start : String,
	@SerializedName("end") val end : String,
	@SerializedName("is_free") val is_free : Boolean,
	@SerializedName("poster_url") val poster_url : String,
	@SerializedName("ticket_url") val ticket_url : String,
	@SerializedName("phone") val phone : String,
	@SerializedName("email") val email : String,
	@SerializedName("facebook_url") val facebook_url : String,
	@SerializedName("twitter_url") val twitter_url : String,
	@SerializedName("hashtag") val hashtag : String,
	@SerializedName("web_url") val web_url : String,
	@SerializedName("live_url") val live_url : String,
	@SerializedName("android_url") val android_url : String,
	@SerializedName("ios_url") val ios_url : String,
	@SerializedName("format") val format : Format,
	@SerializedName("category") val category : Category,
	@SerializedName("venue") val venue : Venue,
	@SerializedName("tags") val tags : List<Tags>
)
