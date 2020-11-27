package com.example.jirataskmvvm.Room




data class EventsRm(

    val id: Int,
    val name: String,
    val slug: String,
    val url: String,
    val content: String,
    val start: String,
    val end: String,
    val is_free: Boolean,
    val poster_url: String,
    val ticket_url: String,
    val phone: String,
    val email: String,
    val facebook_url: String,
    val twitter_url: String,
    val hashtag: String,
    val web_url: String,
    val live_url: String,
    val android_url: String,
    val ios_url: String,
    val format: FormatRm,
    val category: CategoryRm,
    val venue: VenueRm,
    val tags: List<TagsRm>

)