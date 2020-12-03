package com.example.jirataskmvvm.view.eventDetailFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.utils.backButtonHandler
import com.example.jirataskmvvm.utils.getDate
import com.example.jirataskmvvm.utils.loadImage
import kotlinx.android.synthetic.main.fragment_event_detail_page.view.*


class EventDetailFragment : Fragment() {

    private val args: EventDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val action = EventDetailFragmentDirections.goToEventListFragmentFromDetails()
        backButtonHandler(this, requireActivity(), action)
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_event_detail_page, container, false)

        view.eventHeader.text = args.event.name
        view.headerImage.loadImage(args.event.poster_url)
        view.price.text = when (args.event.is_free) {
            false -> getString(R.string.ucretli)
            else -> getString(R.string.ucretsiz)
        }

        view.ticket.text = getString(R.string.bilet_link) + args.event.ticket_url
        view.detailCategory.text =
            getString(R.string.event_category) + args.event.category
        view.detailFormat.text = getString(R.string.event_format) + args.event.format
        view.startDate.text =
            getString(R.string.event_start_date) + getDate(args.event.start)
        view.endDate.text = getString(R.string.event_end_date) + getDate(args.event.end)

        if (args.event.cityId == 99) {
            view.address.text = getString(R.string.event_online)
        } else {
            view.address.text = getString(R.string.event_address) + args.event.cityName
        }

        return view
    }


}