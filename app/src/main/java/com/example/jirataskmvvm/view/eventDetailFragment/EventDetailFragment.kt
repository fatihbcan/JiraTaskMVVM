package com.example.jirataskmvvm.view.eventDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.jirataskmvvm.R
import com.example.jirataskmvvm.databinding.FragmentEventDetailPageBinding


class EventDetailFragment : Fragment() {

    private val args: EventDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val viewWithBinding: FragmentEventDetailPageBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_event_detail_page,
            container,
            false
        )
        viewWithBinding.eventDetail = args.event

        return viewWithBinding.root
    }

}