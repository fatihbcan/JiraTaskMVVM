package com.example.jirataskmvvm.model.apiClasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class deneme(
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            TODO("format"),
            TODO("category"),
            TODO("venue"),
            TODO("tags")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(slug)
        parcel.writeString(url)
        parcel.writeString(content)
        parcel.writeString(start)
        parcel.writeString(end)
        parcel.writeByte(if (is_free) 1 else 0)
        parcel.writeString(poster_url)
        parcel.writeString(ticket_url)
        parcel.writeString(phone)
        parcel.writeString(email)
        parcel.writeString(facebook_url)
        parcel.writeString(twitter_url)
        parcel.writeString(hashtag)
        parcel.writeString(web_url)
        parcel.writeString(live_url)
        parcel.writeString(android_url)
        parcel.writeString(ios_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<deneme> {
        override fun createFromParcel(parcel: Parcel): deneme {
            return deneme(parcel)
        }

        override fun newArray(size: Int): Array<deneme?> {
            return arrayOfNulls(size)
        }
    }
}