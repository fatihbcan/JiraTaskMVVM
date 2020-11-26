package com.example.jirataskmvvm.view.eventDetailPage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.utils.getDate
import com.example.jirataskmvvm.utils.loadImage
import kotlinx.android.synthetic.main.fragment_event_detail_page.view.*


class EventDetailPage : Fragment() {

    val args: EventDetailPageArgs by navArgs()


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_event_detail_page, container, false)


        view.eventHeader.text = args.eventDetails.name
        view.headerImage.loadImage(args.eventDetails.poster_url)
        view.price.text = when (args.eventDetails.is_free) {
            false -> getString(R.string.ucretli)
            else -> getString(R.string.ucretsiz)
        }

        view.ticket.text = getString(R.string.bilet_link) + args.eventDetails.ticket_url
        view.detailCategory.text = getString(R.string.event_category) + args.eventDetails.category.name
        view.detailFormat.text = getString(R.string.event_format) + args.eventDetails.format.name
        view.startDate.text = getString(R.string.event_start_date) + getDate(args.eventDetails.start)
        view.endDate.text = getString(R.string.event_end_date) + getDate(args.eventDetails.end)
        try {
            view.address.text = getString(R.string.event_address) + args.eventDetails.venue.address
        } catch (e: Exception) {
            view.address.text = getString(R.string.event_online)
        }


        /* if(args.eventDetails.venue!=null)
         {
             view.address.text = args.eventDetails.venue.address

         }else{
             view.address.text = "Online Etkinlik"
         }*/

        return view
    }

}