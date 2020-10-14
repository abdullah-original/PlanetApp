package com.example.planetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.planet_detail_fragment.view.*

class PlanetDetailFragment() : Fragment() {

    val args: PlanetDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.planet_detail_fragment, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.planetName.text = args.planet.name
        view.planetDescription.text = args.planet.description
    }
}
