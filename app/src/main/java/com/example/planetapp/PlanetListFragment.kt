package com.example.planetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.planet_list_fragment.*


interface PlanetListener {
    fun onPlanetTapped(planet : Planet)
}

class PlanetListFragment : Fragment(), PlanetListener {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private val viewModel: PlanetListViewModel by viewModels()

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

        viewAdapter = RecycleAdapter(viewModel.planetsArray, this)

        view_planet_list // this is xml id
            .apply {
                setHasFixedSize(true)

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter
            }
    }
    override fun onPlanetTapped(planet: Planet) {
        findNavController().navigate(PlanetListFragmentDirections.actionPlanetListFragmentToPlanetDetailFragment(planet))
    }
}
