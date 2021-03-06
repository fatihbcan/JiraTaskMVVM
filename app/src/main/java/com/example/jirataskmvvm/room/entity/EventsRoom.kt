package com.example.jirataskmvvm.room.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "events_table")
data class EventsRoom(

    @PrimaryKey(autoGenerate = true)
    val eId: Int,
    val name: String,
    val start: String,
    val end: String,
    val is_free: Boolean,
    val poster_url: String,
    val ticket_url: String,
    val format: String,
    val category: String,
    val cityId: Int,
    val address: String

) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(eId)
        parcel.writeString(name)
        parcel.writeString(start)
        parcel.writeString(end)
        parcel.writeByte(if (is_free) 1 else 0)
        parcel.writeString(poster_url)
        parcel.writeString(ticket_url)
        parcel.writeString(format)
        parcel.writeString(category)
        parcel.writeInt(cityId)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventsRoom> {
        override fun createFromParcel(parcel: Parcel): EventsRoom {
            return EventsRoom(parcel)
        }

        override fun newArray(size: Int): Array<EventsRoom?> {
            return arrayOfNulls(size)
        }
    }
}