package com.example.jirataskmvvm.view.eventDetailPage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_event_detail_page.view.*
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.utils.getDate
import com.example.jirataskmvvm.utils.loadImage

import java.lang.Exception


class EventDetailPage : Fragment() {

    val args: EventDetailPageArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_event_detail_page, container, false)


        view.findViewById<TextView>(R.id.eventHeader).text = args.eventDetails.name
        view.findViewById<ImageView>(R.id.headerImage).loadImage(args.eventDetails.poster_url)
        view.findViewById<TextView>(R.id.price).text = when(args.eventDetails.is_free){
            false -> "Ücretli"
            else -> "Ücretsiz"
        }

        view.ticket.text = "Bilet Linki : " + args.eventDetails.ticket_url
        view.detailCategory.text = "Kategori : " + args.eventDetails.category.name
        view.detailFormat.text = "Format : " + args.eventDetails.format.name
        view.startDate.text = "Başlangıç Tarihi : " + getDate(args.eventDetails.start)
        view.endDate.text = "Bitiş Tarihi : " + getDate(args.eventDetails.end)
        try {
            view.address.text = "Adres : " + args.eventDetails.venue.address
        }catch (e: Exception){
            view.address.text = "Online Etkinlik"
            Log.e("hata",e.toString())
        }

        return view
    }



}