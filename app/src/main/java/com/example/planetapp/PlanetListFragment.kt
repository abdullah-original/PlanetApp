package com.example.planetapp

import android.R.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.planet_list_fragment.view.*

class PlanetListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.planet_list_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val mars = Planet("Mars", "This is Mars")
        val earth = Planet("Earth", "This is Earth")
        val mercury = Planet("Mercury", "This is Mercury")

        val planetsArray = listOf(mars, earth, mercury)

        val adapter =
            ArrayAdapter(requireContext(),
                layout.simple_list_item_1,
                planetsArray.map { it.name })
        view.planet_list.adapter = adapter


        view.planet_list.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val action = PlanetListFragmentDirections
                findNavController().navigate(action.actionPlanetListFragmentToPlanetDetailFragment())
            }
    }
}
