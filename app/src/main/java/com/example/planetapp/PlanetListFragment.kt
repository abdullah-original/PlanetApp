package com.example.planetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.planet_list_fragment.*

class PlanetListFragment : Fragment() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

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

        val planetsArray = arrayOf(mars, earth, mercury, mars, mars, earth, mercury, earth)

        viewAdapter = RecycleAdapter(planetsArray)

        view_planet_list // this is xml id
            .apply {
                setHasFixedSize(true)

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter
            }


//        recyclerView.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                val action = PlanetListFragmentDirections
//                findNavController().navigate(action.actionPlanetListFragmentToPlanetDetailFragment())
//            }
    }
}
